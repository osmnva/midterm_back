package org.example.learning_platform.service;

public interface OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    OAuth2User loadUser(OAuth2UserRequest userRequest);
}
