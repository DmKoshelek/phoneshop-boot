package com.expertsoft.phoneshop.persistence.repository;

import com.expertsoft.phoneshop.persistence.model.GitHubUser;
import com.expertsoft.phoneshop.persistence.model.LoginFormUser;
import com.expertsoft.phoneshop.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<LoginFormUser> findLoginFormUserByLogin(String login);

    Optional<GitHubUser> findGitHubUserByGitHubId(Integer id);
}
