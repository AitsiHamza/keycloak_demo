package com.example.demomaven.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }

}
