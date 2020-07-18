package com.bookcode.firstrp.filetransfer;

import com.bookcode.firstrp.upload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MyFileRepository {
    private final List<MyFile> myFileList = new ArrayList<>();
    @Autowired
    FileService fileService;

    @PostConstruct
    public void init(){
        MyFile myFile = new MyFile();
        myFile.setId(1L);
        myFile.setName("data/songlists.json");
        myFile.setContent(fileService.getContent(myFile.getName()));
        myFileList.add(myFile);
        myFile = new MyFile();
        myFile.setId(2L);
        myFile.setName("data/test.txt");
        myFile.setContent(fileService.getContent(myFile.getName()));
        myFileList.add(myFile);

    }
    public Mono<MyFile> getMyFilesById(String id) {
        return Mono.justOrEmpty(myFileList.stream().filter(myFile -> {
            return myFile.getId().equals(Long.valueOf(id));
        }).findFirst().orElse(null));
    }
    public Flux<MyFile> getMyFiles() {
        return Flux.fromIterable(myFileList);
    }


}
