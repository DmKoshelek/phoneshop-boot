package com.expertsoft.phoneshop;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.expertsoft.phoneshop.PhoneShopConstants.*;

@Configuration
@EnableConfigurationProperties
public class PhoneShopConfiguration implements WebMvcConfigurer {

    private static final String LOGIN_PAGE = "loginPage";
    private static final String ADMIN_PANEL_PAGE = "admin/adminPanelPage";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(LOGIN_PATH).setViewName(LOGIN_PAGE);
        registry.addViewController(ADMIN_PATH).setViewName(ADMIN_PANEL_PAGE);
        registry.addRedirectViewController(ROOT_PATH, PHONES_PATH);
    }
}
