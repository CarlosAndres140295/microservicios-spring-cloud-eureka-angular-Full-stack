package com.andres.microserviceusuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceUsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceUsuariosApplication.class, args);
        System.out.print("Api running localhost:8001/api/v1/students");
    }

}
