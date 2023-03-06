package com.example.demogradle.controllers;

import com.example.demogradle.dtos.ProductDTO;
import lombok.AllArgsConstructor;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

    private KeycloakRestTemplate keycloakRestTemplate;

    @GetMapping("/1")
    public String test1(){
        return keycloakRestTemplate
                .getForObject("http://localhost:8085/test", String.class);
    }
    @GetMapping("/2")
    public List<ProductDTO> test2(){
        return keycloakRestTemplate
                .getForObject("http://localhost:8085/products/all", ArrayList.class);
    }

}
