package com.mixapp.venitar.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.spring.web.plugins.Docket;

public interface SwaggerConfigInterface {
    @Bean
    Docket apiDocket();

    void addResourceHandlers(ResourceHandlerRegistry registry);
}
