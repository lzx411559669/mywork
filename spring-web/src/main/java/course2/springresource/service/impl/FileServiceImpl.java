package course2.springresource.service.impl;

import course2.springresource.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    ResourceLoader loader;
    @Override
    public String getContent(String name) {
        try {
            InputStream in =  loader.getResource(name).getInputStream();
            return IOUtils.toString(in,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
