package com.ism.gestion_absences.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "de5kqcjcm",
            "api_key", "677972111763434",
            "api_secret", "USfU820KpsB9srsULbIG2jFREGs",
            "secure", true));
    }
}
