package com.bookcode.handler;
import com.bookcode.model.Book;
import com.bookcode.responsitory.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
@Component
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;
    public Mono<ServerResponse> handleGetBooks(ServerRequest request) {
        return ServerResponse.ok().body(bookRepository.getBooks(), Book.class);
    }
    public Mono<ServerResponse> handleGetBookById(ServerRequest request) {
        return bookRepository.getBookById(request.pathVariable("id"))
                .flatMap(book -> ServerResponse.ok().body(Mono.just(book), Book.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}
