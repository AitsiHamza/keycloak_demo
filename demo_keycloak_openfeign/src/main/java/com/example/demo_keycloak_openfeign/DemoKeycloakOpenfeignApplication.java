package com.example.demo_keycloak_openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoKeycloakOpenfeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoKeycloakOpenfeignApplication.class, args);
	}

}
