package com.bookcode.responsitory;

import com.bookcode.model.ModelFile;
import com.bookcode.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ModelFileRepository {
    private final List<ModelFile> modelFileList = new ArrayList<>();
    @Autowired
    FileService fileService;
    @PostConstruct
    public void init() {
        ModelFile modelFile = new ModelFile();
        modelFile.setId(1L);
        modelFile.setName("data/songlists.json");
        modelFile.setContent(fileService.getContent(modelFile.getName()));
        modelFileList.add(modelFile);
        modelFile = new ModelFile();
        modelFile.setId(2L);
        modelFile.setName("data/test.txt");
        modelFile.setContent(fileService.getContent(modelFile.getName()));
        modelFileList.add(modelFile);
    }
    public Mono<ModelFile> getFilesById(String id) {
        return Mono.justOrEmpty(modelFileList.stream().filter(modelFile -> {
            return modelFile.getId().equals(Long.valueOf(id));
        }).findFirst().orElse(null));
    }
    public Flux<ModelFile> getFiles() {
        return Flux.fromIterable(modelFileList);
    }
}
