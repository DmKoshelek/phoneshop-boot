package com.expertsoft.phoneshop.persistence.model;

import org.springframework.security.oauth2.core.user.OAuth2User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

@Entity
public class GitHubUser extends User implements OAuth2User {

    private String name;
    private String bio;
    private String avatarUrl;
    private String location;
    private String company;
    @Column(unique = true)
    private Integer gitHubId;

    @Transient
    private Map<String, Object> attributes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getGitHubId() {
        return gitHubId;
    }

    public void setGitHubId(Integer gitHubId) {
        this.gitHubId = gitHubId;
    }

    @Override
    public Map<String, Object> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new HashMap<>();
            this.attributes.put("id", this.getId());
            this.attributes.put("name", this.getName());
            this.attributes.put("username", this.getLogin());
            this.attributes.put("bio", this.getBio());
            this.attributes.put("avatarUrl", this.getAvatarUrl());
            this.attributes.put("location", this.getLocation());
            this.attributes.put("company", this.getCompany());
        }
        return attributes;
    }
}
