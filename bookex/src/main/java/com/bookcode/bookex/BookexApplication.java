package com.bookcode.bookex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class BookexApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookexApplication.class, args);
    }
}
