package com.bookcode.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;

@EnableBinding(Source.class)
public class SendServer {

    @Autowired
    private Source source;

    public void sendMessage(Flux<String> flux) {
        try {
            source.output().send(MessageBuilder.withPayload(flux).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
