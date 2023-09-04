package com.olliniinioja.demo.yle.TeleText.repository;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Service
public class FileRepository {

    public InputStream getFile(String path) throws FileNotFoundException {
        try {
            File file = ResourceUtils.getFile("classpath:" + path);
            return new FileInputStream(file);
        } catch(FileNotFoundException e) {
            throw new FileNotFoundException("Could not find file: " + path);
        }
    }
}
