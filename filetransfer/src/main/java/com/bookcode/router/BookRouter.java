package com.bookcode.router;
import com.bookcode.handler.BookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class BookRouter {
    @Bean
    public RouterFunction<?> routerFunction(BookHandler bookHandler) {
        return route(GET("/booklist").and(accept(MediaType.APPLICATION_JSON)),  bookHandler::handleGetBooks)
                .and(route(GET("/book/{id}").and(accept(MediaType.APPLICATION_JSON)),  bookHandler::handleGetBookById));
    }
}