package com.bookcode.firstrp.filetransfer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class Routes {

    @Bean
    public RouterFunction<?> routerFunction(MyFileHandler  myFileHandler) {
        return route(GET("/api/myfile").and(accept(MediaType.APPLICATION_JSON)),  myFileHandler::handleGetMyFile)
                .and(route(GET("/api/myfile/{id}").and(accept(MediaType.APPLICATION_JSON)),  myFileHandler::handleGetMyFileById));
    }
}