package com.example.gestioncommande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class GestionCommandeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionCommandeApplication.class, args);
    }

}
