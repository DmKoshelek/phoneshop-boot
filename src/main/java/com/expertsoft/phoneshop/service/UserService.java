package com.expertsoft.phoneshop.service;

import com.expertsoft.phoneshop.persistence.model.GitHubUser;
import com.expertsoft.phoneshop.persistence.model.LoginFormUser;
import com.expertsoft.phoneshop.persistence.model.User;
import com.expertsoft.phoneshop.persistence.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public Page<User> getUsersPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Optional<LoginFormUser> getLoginFormUserByLogin(String login) {
        return userRepository.findLoginFormUserByLogin(login);
    }

    public Optional<GitHubUser> getUserByGitHubId(Integer id) {
        return userRepository.findGitHubUserByGitHubId(id);
    }

    public GitHubUser createNewGitHubUser(OAuth2User auth2User) {
        var user = formatNewUser(auth2User.getAttributes());
        userRepository.save(user);
        return user;
    }

    private GitHubUser formatNewUser(Map<String, Object> attributes) {
        var user = new GitHubUser();
        user.setLogin(attributes.getOrDefault("login", StringUtils.EMPTY).toString());
        user.setLocation(attributes.getOrDefault("location", StringUtils.EMPTY).toString());
        user.setAvatarUrl(attributes.getOrDefault("avatar_url", StringUtils.EMPTY).toString());
        user.setBio(attributes.getOrDefault("bio", StringUtils.EMPTY).toString());
        user.setCompany(attributes.getOrDefault("company", StringUtils.EMPTY).toString());
        user.setName(attributes.getOrDefault("name", StringUtils.EMPTY).toString());
        user.setGitHubId((Integer) attributes.getOrDefault("id", 0));
        user.setRole("ROLE_USER");
        return user;
    }
}
