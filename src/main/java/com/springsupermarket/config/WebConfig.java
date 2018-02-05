package com.springsupermarket.config;

import com.springsupermarket.controller.IndexController;
import com.springsupermarket.security.OAuth2SecurityConfig;
import com.springsupermarket.security.CustomAuthenticationProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {IndexController.class, OAuth2SecurityConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String headers[] = {"X-Requested-With", "Content-Type", "Authorization", "Origin", "Accept",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"};
        String methods[] = {"POST", "GET", "PUT", "OPTIONS", "DELETE"};

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods(methods)
                .allowedHeaders(headers)
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
