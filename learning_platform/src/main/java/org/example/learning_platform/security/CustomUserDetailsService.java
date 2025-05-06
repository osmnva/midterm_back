package org.example.learning_platform.service;

import org.example.learning_platform.entity.User;
import org.example.learning_platform.repository.UserRepository;
import org.example.learning_platform.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return new CustomUserDetails(user);
    }
}