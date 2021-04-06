package com.expertsoft.phoneshop.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.expertsoft.phoneshop.PhoneShopConstants.LOGIN_PATH;
import static com.expertsoft.phoneshop.PhoneShopConstants.PHONES_PATH;
import static com.expertsoft.phoneshop.PhoneShopConstants.ROOT_PATH;

@Configuration
@EnableConfigurationProperties
public class PhoneShopConfiguration implements WebMvcConfigurer {

    private static final String LOGIN_PAGE = "loginPage";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(LOGIN_PATH).setViewName(LOGIN_PAGE);
        registry.addRedirectViewController(ROOT_PATH, PHONES_PATH);
    }
}
