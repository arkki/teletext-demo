package com.olliniinioja.demo.yle.TeleText.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FileNotFoundException extends Exception {

    public FileNotFoundException(String e) {
        super(e);
    }
}
