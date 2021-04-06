package com.expertsoft.phoneshop.service;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DatabaseOAuth2UserService extends DefaultOAuth2UserService {

    @Resource
    private UserService userService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        var user = super.loadUser(userRequest);
        return userService.getUserByGitHubId(user.getAttribute("id"))
                .orElseGet(() -> userService.createNewGitHubUser(user));
    }
}
