package com.example.homework20.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Некорректный ввод")
public class WrongEntryException extends RuntimeException{

    public WrongEntryException() {
    }
}
