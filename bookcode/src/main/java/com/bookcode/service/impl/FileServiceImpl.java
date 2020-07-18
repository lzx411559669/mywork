package com.bookcode.service.impl;

import com.bookcode.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FileServiceImpl implements FileService {
    //通过org.springframework.core.io.ResourceLoader这个服务提供任意文件的读取
    @Autowired
    ResourceLoader loader;
    @Override
    public String getContent(String name) {
        try {
            InputStream in = loader.getResource(name).getInputStream();
            //以字符串的形式返回文件内容
            return IOUtils.toString(in, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
