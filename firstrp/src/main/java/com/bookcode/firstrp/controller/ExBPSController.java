package com.bookcode.firstrp.controller;

import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.BufferOverflowStrategy;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import java.util.concurrent.CountDownLatch;
@RestController
public class ExBPSController {
    @GetMapping("/exBPSOne")
    public String exBPSOne() {
        Flux<Integer> numberGenerator = Flux
                .create(x -> {
                    System.out.println("Requested Events :" + x.requestedFromDownstream());
                    int number = 1;
                    while (number < 100) {
                        x.next(number);
                        number++;
                    }
                    x.complete();
                });
        CountDownLatch latch = new CountDownLatch(1);
        numberGenerator.subscribe(
                new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        System.out.println("OnNext value: " + value);
                    }

                    @Override
                    protected void hookOnError(Throwable throwable) {
                        throwable.printStackTrace();
                        latch.countDown();
                    }

                    @Override
                    protected void hookOnComplete() {
                        latch.countDown();
                    }
                });
        return "BPSOne ok";
    }

    @GetMapping("/exBPSTwo")
    public String exBPSTwo() {
        Flux<Integer> numberGenerator = Flux
                .create(x -> {
                            System.out.println("Requested Events :" + x.requestedFromDownstream());
                            int number = 1;
                            while (number < 10) {
                                x.next(number);
                                number++;
                            }
                            x.complete();
                        },
                        FluxSink.OverflowStrategy.ERROR);
        numberGenerator.subscribe(
                t ->
                        System.out.print(t + " "));
        System.out.println();
        return "BPSTwo ok";
    }

    @GetMapping("/exBPSThree")
    public String exBPSThree() {
        Flux<Integer> numberGenerator = Flux
                .create(x -> {
                    System.out.println("Requested Events :" + x.requestedFromDownstream());
                    int number = 1;
                    while (number < 100) {
                        x.next(number);
                        number++;
                    }
                    x.complete();
                });
        CountDownLatch latch = new CountDownLatch(1);
        numberGenerator
                .onBackpressureDrop(x -> System.out.println("Dropped :" + x))
                .subscribe(new BaseSubscriber<Integer>() {
                });
        return "BPSThree ok";
    }

    @GetMapping("/exBPSFour")
    public String exBPSFour() {
        Flux<Integer> numberGenerator = Flux
                .create(x -> {
                    System.out.println("Requested Events :" + x.requestedFromDownstream());
                    int number = 1;
                    while (number < 100) {
                        x.next(number);
                        number++;
                    }
                    x.complete();
                });
        CountDownLatch latch = new CountDownLatch(1);
        numberGenerator
                .onBackpressureBuffer(2, x -> System.out.println("Dropped :" + x), BufferOverflowStrategy.DROP_LATEST)
                .subscribe(new BaseSubscriber<Integer>() {
                });
        return "BPSFour ok";
    }
}