package com.bookcode.reactivestreamkafka;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(Sink.class)
public class Msgsink {
    @StreamListener(Sink.INPUT)
    public void recieve(@Payload String message){
        System.out.println(message);
    }
}