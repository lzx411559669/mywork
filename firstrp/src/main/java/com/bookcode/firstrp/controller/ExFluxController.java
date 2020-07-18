package com.bookcode.firstrp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;
@RestController
@RequestMapping("/flux")
public class ExFluxController {
    @GetMapping("/exJust")
    public Flux<String> exJust() {
        Flux<String> stringFlux = Flux.just("Blue ", "Yellow ", "Black ");
        System.out.println("Flux.just的用法示例：");
        Flux.just("Red").subscribe(t -> System.out.println(t));
        //多个元素
        Flux.just("just", "just1", "just2").subscribe(t -> System.out.println(t));
        return stringFlux;
    }
    @GetMapping("/exFrom")
    public Flux<String> exFrom() {
        System.out.println("Flux.from的用法示例。");
        Flux.from(Flux.just("Flux: ", "just ", "just1 ", "just2."))
                .subscribe(t -> System.out.print(t));
        System.out.println();
        Flux.from(Mono.just("Mono.")).subscribe(t -> System.out.println(t));
        return Flux.from(Flux.just("just ", "just1 ", "just2 "));
    }
    @GetMapping("/exfromArray")
    public Flux<Integer> exfromArray() {
        System.out.println("Flux.fromArray的用法示例。");
        return Flux.fromArray(new Integer[]{1, 1, 2, 3, 5, 8, 13});
    }
    @GetMapping("/exfromIterable")
    public Flux<String> exfromIterable() {
        System.out.println("Flux.fromIterable的用法示例。");
        return Flux.fromIterable(Arrays.asList("Red ", "Blue ", "Yellow ", "Black."));
    }
    @GetMapping("/exfromStream")
    public Flux<Integer> exfromStream() {
        System.out.println("Flux.fromStream【Java 8 stream】的用法示例。");
        return Flux.fromStream(IntStream.range(1, 10).boxed());
    }
    @GetMapping("/exDefer")
    public Flux<String> exDefer() {
        System.out.println("Flux.defer的用法示例。");
        return Flux.defer(() -> Flux.just("just", "just1", "just2"));
    }
    @GetMapping("/exEmpty")
    public Flux<String> exEmpty() {
        System.out.println("Flux.empty的用法示例。");
        return Flux.empty();
    }
    @GetMapping("/exError")
    public Flux<String> exError() {
        System.out.println("Flux.error的用法示例。");
        return Flux.error(new RuntimeException());
    }
    @GetMapping("/exNever")
    public Flux<String> exNever() {
        System.out.println("Flux.never的用法示例。");
        return Flux.never();
    }
    @GetMapping("/exCreate")
    public String exCreate() {
        System.out.println("Flux.create的用法：");
        Flux<Long> fibonacciGeneratorTwo = Flux.create(e -> {
            long current = 1, prev = 0;
            AtomicBoolean stop = new AtomicBoolean(false);
            e.onCancel(() -> {
                stop.set(true);
                System.out.println("******* Stop Received ****** ");
            });
            while (current > 0) {
                e.next(current);
                System.out.print(" generated " + current);
                long next = current + prev;
                prev = current;
                current = next;
            }
            e.complete();
        }, FluxSink.OverflowStrategy.IGNORE);
        List<Long> fibonacciSeries = new LinkedList<>();
        int size = 50;
        fibonacciGeneratorTwo.take(size).subscribe(t -> {
            fibonacciSeries.add(t);
        });
        System.out.println(fibonacciSeries);
        return Long.toString(fibonacciSeries.get(size - 1).longValue());
    }
    @GetMapping("/exGenerate")
    public String exGenerate() {
        System.out.println("Flux.generate的用法：");
        Flux<Long> fibonacciGenerator = Flux.generate(
                () -> Tuples.of(0L, 1L),
                (state, sink) -> {
                    sink.next(state.getT1());
                    System.out.println("generated " + state.getT1());
                    return Tuples.of(state.getT2(), state.getT1() + state.getT2());
                });
        List<Long> fibonacciSeries = new LinkedList<>();
        int size = 50;
        fibonacciGenerator.take(size).subscribe(t -> {
            System.out.println("consuming " + t);
            fibonacciSeries.add(t);
        });
        System.out.println(fibonacciSeries);
        return Long.toString(fibonacciSeries.get(size - 1).longValue());
    }
}