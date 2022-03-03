package com.hexagonal.training.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hexagonal.training")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
