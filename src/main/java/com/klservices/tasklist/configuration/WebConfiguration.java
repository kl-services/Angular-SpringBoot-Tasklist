package com.klservices.tasklist.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    // DO NOT USE WebMvcConfigurationSupport (or @EnableWebMvc)!!!  This disables default Spring Boot dispatcher
    // settings, disallowing automatic redirection to static resources...  Needed to implement the interface and
    // change to public accessor for WebMvcConfigurer.
    //TODO: ensure the security of the new configuration!!!

        @Override
        public void extendMessageConverters( List<HttpMessageConverter<?>> converters ) {
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter jacksonConverter = (MappingJackson2HttpMessageConverter) converter;
                jacksonConverter.setPrettyPrint(true);
            }
        }
    }

}
