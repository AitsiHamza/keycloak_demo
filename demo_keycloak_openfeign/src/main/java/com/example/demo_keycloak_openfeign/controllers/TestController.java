package com.example.demo_keycloak_openfeign.controllers;

import com.example.demo_keycloak_openfeign.services.ServiceClient;
import lombok.AllArgsConstructor;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {
    private ServiceClient serviceClient;
    private KeycloakRestTemplate keycloakRestTemplate;

    @GetMapping("/2")
    public ResponseEntity<String> test2(){
        String message=keycloakRestTemplate
                .getForObject("http://localhost:8085/test", String.class);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    //@RolesAllowed({"ADMIN_ROLE", "USER_ROLE"})
    @GetMapping("/1")
    public ResponseEntity<String> test1(){
        ResponseEntity<String> testMessage=null;
        try {
            testMessage = serviceClient.getTestMessage();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return testMessage;
    }
    //@RolesAllowed("ADMIN_ROLE")
    @GetMapping("/3")
    public ResponseEntity<String> test3(){
        ResponseEntity<String> testMessage=serviceClient.getTestMessage();
        return testMessage;
    }
}
