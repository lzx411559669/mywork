package com.bookcode.handler;
import com.bookcode.model.ModelFile;
import com.bookcode.responsitory.ModelFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
@Component
public class ModelFileHandler {
    @Autowired
    private ModelFileRepository modelFileRepository;
    public Mono<ServerResponse> handleGetFile(ServerRequest request) {
        return ServerResponse.ok().body(modelFileRepository.getFiles(), ModelFile.class);
    }
    public Mono<ServerResponse> handleGetFileById(ServerRequest request) {
        return modelFileRepository.getFilesById(request.pathVariable("id"))
                .flatMap(modelFile -> ServerResponse.ok().body(Mono.just(modelFile), ModelFile.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
