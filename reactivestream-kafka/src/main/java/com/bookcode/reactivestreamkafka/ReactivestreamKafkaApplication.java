package com.bookcode.reactivestreamkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ReactivestreamKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactivestreamKafkaApplication.class, args);
    }

}
