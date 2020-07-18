package com.bookcode.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ProducerController {

    @Autowired
    private SendServer service;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void send(){
        Flux<String> flux = Flux.just("hello","world");
        service.sendMessage(flux);
    }

}