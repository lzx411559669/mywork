package com.bookcode.firstrp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.time.Duration;
@RestController
@RequestMapping("hello")
public class ExRangeController {
    @GetMapping("/exRange")
    public String exRange() {
        System.out.println("Flux.range and interval的用法示例。");
        Flux.interval(Duration.ofNanos(1)).elementAt(16).subscribe(t -> System.out.println("语句在前，但是有等待"+t));
        System.out.println("下面语句在后");
        Flux.range(1,100).take(15).subscribe(t -> System.out.print(" "+t));
        System.out.println();
        return "range and interval ok";
    }
}