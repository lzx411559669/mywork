package com.bookcode.gatewayex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayexApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayexApplication.class, args);
    }
}
