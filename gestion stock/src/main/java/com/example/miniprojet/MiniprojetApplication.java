package com.example.miniprojet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient

public class MiniprojetApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniprojetApplication.class, args);
    }

}
