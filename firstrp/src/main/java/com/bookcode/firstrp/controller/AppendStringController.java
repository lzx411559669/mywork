package com.bookcode.firstrp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
@RestController
public class AppendStringController {
    @GetMapping( "/appendstringMVC")
    public String AppendstringMVC() {
        StringBuilder strResult = new StringBuilder();
        Flux<String> stringFlux = Flux.just("Quick", "brown", "fox", "jumped", "over", "the", "wall");
        stringFlux.subscribe(t -> {
            strResult.append(t).append(" ");
        });
        return strResult.toString() + ".";
    }
    @GetMapping(path = "/appendstringReactive")
    public Flux<String> ppendstringReactive() {
        Flux<String> stringFlux = Flux.just("Quick ", "brown ", "fox ", "jumped ", "over ", "the ", "wall.");
        return stringFlux;
    }
}
