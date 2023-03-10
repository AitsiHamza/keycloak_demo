package com.example.demo_keycloak_openfeign.configuration;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
@Slf4j
public class FeignConfig {

    private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
    private final ClientRegistrationRepository clientRegistrationRepository;

    public FeignConfig(OAuth2AuthorizedClientService service, ClientRegistrationRepository repository) {
        this.oAuth2AuthorizedClientService = service;
        this.clientRegistrationRepository = repository;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId("keycloak");
        OAuthClientCredentialsFeignManager oAuthClientCredentialsFeignManager = new OAuthClientCredentialsFeignManager(authorizedClientManager(), clientRegistration);
        log.info("getting the accessToken : ");
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer " + oAuthClientCredentialsFeignManager.getAccessToken());
        };
    }

    @Bean
    OAuth2AuthorizedClientManager authorizedClientManager() {
        AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager =
                new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, oAuth2AuthorizedClientService);
        authorizedClientManager.setAuthorizedClientProvider(OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build());
        return authorizedClientManager;
    }
}
