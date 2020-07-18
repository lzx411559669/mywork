package com.example.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.IntStream;

@RestController
public class HelloWorldController {

    static final String HELLO_WORLD = "Hello World";

    @GetMapping("h")
    public String hello(){
        return HELLO_WORLD;
    }

    /**
     * 将数据转换成流的方式输出
     * Mono是单条数据,Flux一般处理集合或者数组
     * @return
     */
    @GetMapping("/hello1")
    public Mono<String> hello1(){
        return Mono.just(HELLO_WORLD);
    }

    /**
     *  MediaType.TEXT_EVENT_STREAM_VALUE 设置这个头部是让flux变成响应式的
     *  如果不设置这个参数，flux就相当于List Array
     * @return
     */
    @GetMapping(value = "/hellon",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> hellon(){
        return Flux
                .fromStream(IntStream.range(1,20).mapToObj(item ->HELLO_WORLD + item))
                .doOnNext(item -> {
                    try {
                        //等待500毫秒响应一次数据
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * 定义一个路由函数
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> function(){
        return RouterFunctions.route(
                RequestPredicates.GET("/helloF"),
                serverRequest -> {
                    return ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).bodyValue(HELLO_WORLD);
                }
        );
    }
}
