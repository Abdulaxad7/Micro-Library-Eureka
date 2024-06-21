package com.library.librarypurchaseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class LibraryPurchaseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryPurchaseServiceApplication.class, args);
    }

}
