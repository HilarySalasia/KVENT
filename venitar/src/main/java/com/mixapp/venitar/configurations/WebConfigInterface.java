package com.mixapp.venitar.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

public interface WebConfigInterface {
    @Bean
    ViewResolver getViewResolver();

    void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);

    void addResourceHandlers(ResourceHandlerRegistry registry);
}
