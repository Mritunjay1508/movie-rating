package com.movieratingapp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.movieratingapp.application")
public class MovieRatingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRatingAppApplication.class, args);
    }
}
