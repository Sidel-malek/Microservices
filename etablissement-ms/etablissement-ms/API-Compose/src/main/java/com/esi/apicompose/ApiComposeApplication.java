package com.esi.apicompose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class ApiComposeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiComposeApplication.class, args);
    }

}
