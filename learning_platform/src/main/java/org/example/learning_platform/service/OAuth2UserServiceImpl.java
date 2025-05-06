package org.example.learning_platform.service;

import org.example.learning_platform.entity.Role;
import org.example.learning_platform.entity.User;
import org.example.learning_platform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OAuth2UserServiceImpl<OAuth2User, OAuth2UserRequest> implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();

    public OAuth2UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String email = oAuth2User.toString();
        if (email == null) {
            throw new IllegalArgumentException("Email not found from OAuth2 provider");
        }

        userRepository.findByEmail(email).orElseGet(() -> {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setUsername(email);
            newUser.setEnabled(true);
            newUser.setRoles(List.of());
            return userRepository.save(newUser);
        });

        return oAuth2User;
    }

    private class DefaultOAuth2UserService {
        public OAuth2User loadUser(OAuth2UserRequest userRequest) {
            return null;
        }
    }
}
