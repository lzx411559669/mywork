package com.bookcode.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

@EnableBinding(Sink.class)
public class MsgSink {

    @StreamListener(Sink.INPUT)
    public void process(Flux<String> flux) {
       flux.subscribe(s -> {
           System.out.println(s.toUpperCase());

       });

     /*  Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            System.out.println("Acknowledgment provided");
            acknowledgment.acknowledge();
        }*/
    }
}
