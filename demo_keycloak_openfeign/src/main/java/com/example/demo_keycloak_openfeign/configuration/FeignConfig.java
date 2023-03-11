package com.example.demo_keycloak_openfeign.configuration;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Configuration
@Slf4j
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
            String authorization = request.getHeader("Authorization");
            log.warn("access token : "+ authorization);
            requestTemplate.header("Authorization", authorization);
        };
    }

}
