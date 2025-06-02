package com.ism.gestion_absences.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // autorise toutes les routes
                        .allowedOrigins("*") // autorise toutes les origines (ATTENTION EN PROD)
                        .allowedMethods("*") // autorise toutes les méthodes (GET, POST, PUT, DELETE, etc.)
                        .allowedHeaders("*") // autorise tous les headers
                        .allowCredentials(false); // désactive les cookies (obligatoire si allowedOrigins est "*")
            }
        };
    }
}
