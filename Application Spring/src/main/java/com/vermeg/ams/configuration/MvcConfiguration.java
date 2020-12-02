package com.vermeg.ams.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
	
	@Bean
	 public BCryptPasswordEncoder passwordEncoder() {
	 BCryptPasswordEncoder bCryptPasswordEncoder = new
	BCryptPasswordEncoder();
	 return bCryptPasswordEncoder;
	 }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        viewControllerRegistry.addViewController("/").setViewName("redirect:/pages/dashboard");
    }

}
