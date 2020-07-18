package com.bookcode.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class ModelFileController {
    @RequestMapping(value = "/uploadhtml")
    public String upload() {
        return "upload";
    }

    @RequestMapping("/downhtml")
    public String download() {
        return "download";
    }

    @ResponseBody
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<String> requestBodyFlux(@RequestPart("file") FilePart filePart) throws IOException {
        System.out.println(filePart.filename());
        Path tempFile = Files.createTempFile("test", filePart.filename());
        //NOTE 方法1
      /*  AsynchronousFileChannel channel =
                AsynchronousFileChannel.open(tempFile, StandardOpenOption.WRITE);
        DataBufferUtils.write(filePart.content(), channel, 0)
                .doOnComplete(() -> {
                    System.out.println("finish");
                })
                .subscribe();*/
        //NOTE 方法二
        filePart.transferTo(tempFile.toFile());
        System.out.println(tempFile.toString());
        return Mono.just("文件：" + filePart.filename() + " 上传成功");
    }

    @ResponseBody
    @GetMapping("/download")
    public Mono<Void> downloadByWriteWith(ServerHttpResponse response) throws IOException {
        ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) response;
        //Content-Disposition这个头部信息将告诉浏览器打开一个文件下载窗口
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = songlists.json");

        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        Resource resource = new ClassPathResource("data/songlists.json");
        File file = resource.getFile();
        return zeroCopyResponse.writeWith(file, 0, file.length());
    }
}
