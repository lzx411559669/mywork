package com.bookcode.router;

import com.bookcode.handler.ModelFileHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ModelFileRouter {
    @Bean
    public RouterFunction<?> routerFunction(ModelFileHandler modelFileHandler) {
        return route(GET("/api/file").and(accept(MediaType.APPLICATION_JSON)), modelFileHandler::handleGetFile)
                .and(route(GET("/api/file/{id}").and(accept(MediaType.APPLICATION_JSON)), modelFileHandler::handleGetFileById));
    }
}