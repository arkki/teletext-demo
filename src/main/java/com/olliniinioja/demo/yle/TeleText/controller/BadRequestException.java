package com.olliniinioja.demo.yle.TeleText.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {

    public BadRequestException(String e) {
        super(e);
    }
}
