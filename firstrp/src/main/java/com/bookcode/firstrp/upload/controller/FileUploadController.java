package com.bookcode.firstrp.upload.controller;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import com.bookcode.firstrp.upload.service.FileService;
import com.bookcode.firstrp.upload.service.impl.FileServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileUploadController {
   /* @Autowired
    ResourceLoader loader;

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IllegalStateException, IOException {
        // 判断是否为空文件
        if (file.isEmpty()) {
            return "上传文件不能为空";
        }
        // 文件类型
        String contentType = file.getContentType();
        // springmvc处理后的文件名
        String fileName = file.getName();

        // 原文件名即上传的文件名
        String origFileName = file.getOriginalFilename();
        // 文件大小
        Long fileSize = file.getSize();

        // 保存文件
        // 可以使用二进制流直接保存
        // 这里直接使用transferTo
        file.transferTo(new File("d://okong-" + origFileName));

        return String.format(file.getClass().getName() + "方式文件上传成功！\n文件名:%s,文件类型:%s,文件大小:%s", origFileName, contentType,fileSize);

    }
    @GetMapping("/download")
    public Flux<String> download(@RequestParam("filename")String filename){
        Flux<String> fluxFile = null;
        List<String> filenames = new ArrayList<>();
        filenames.add("songlists.json");
        filenames.add(("application.properties"));
        Flux<String> fluxFileName = Flux.fromIterable(filenames);



        try {
             InputStream in =  loader.getResource(filename).getInputStream();

            fluxFile =Flux.just(IOUtils.toString(in,"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fluxFile;
    }*/

}