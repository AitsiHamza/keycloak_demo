package com.example.demo_keycloak_openfeign.services;

import com.example.demo_keycloak_openfeign.configuration.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "DEMO-MAVEN", configuration = FeignConfig.class)
//@FeignClient(name = "DEMO-MAVEN", configuration = FeignConfig.class, url = "http://localhost:8085")
public interface ServiceClient {

    @GetMapping("/test")
    ResponseEntity<String> getTestMessage();
}
