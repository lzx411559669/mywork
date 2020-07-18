package com.bookcode.firstrp.WebFlux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @GetMapping("/hello")
    public String hi() {
        return "Hello controller!";
    }
}