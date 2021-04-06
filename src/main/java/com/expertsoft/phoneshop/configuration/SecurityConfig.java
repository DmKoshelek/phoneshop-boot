package com.expertsoft.phoneshop.configuration;


import com.expertsoft.phoneshop.service.DatabaseOAuth2UserService;
import com.expertsoft.phoneshop.service.DatabaseUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    public DatabaseOAuth2UserService databaseOAuth2UserService;

    @Resource
    public DatabaseUserDetailsService databaseUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/phones", "/phones/search")
                    .permitAll()

                    .antMatchers("/phones/**")
                    .hasAnyRole("ADMIN", "USER")

                    .antMatchers("/admin/**")
                    .hasRole("ADMIN")

                    .antMatchers("/**")
                    .permitAll()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error=form")
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                    .loginPage("/login")
                    .failureUrl("/login?error=github")
                    .userInfoEndpoint(userInfo -> userInfo.userService(databaseOAuth2UserService));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(databaseUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
