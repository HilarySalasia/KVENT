package com.mixapp.venitar.configurations;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class EmbeddedTomcat {

    @Bean
    public ConfigurableServletWebServerFactory servletContainer() throws UnknownHostException {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
         return tomcat;
    }
}