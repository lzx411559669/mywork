package com.bookcode.firstrp.filetransfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;



@Component
public class MyFileHandler {
    @Autowired
    private MyFileRepository myFileRepository;

    public Mono<ServerResponse> handleGetMyFile(ServerRequest request) {
        return ServerResponse.ok().body(myFileRepository.getMyFiles(), MyFile.class);
    }

    public Mono<ServerResponse> handleGetMyFileById(ServerRequest request) {
        return myFileRepository.getMyFilesById(request.pathVariable("id"))
                .flatMap(myFile -> ServerResponse.ok().body(Mono.just(myFile), MyFile.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }


}
