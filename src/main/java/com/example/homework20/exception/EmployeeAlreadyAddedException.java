package com.example.homework20.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND, reason = "Такой сотрудник уже добавлен")
public class EmployeeAlreadyAddedException extends RuntimeException{

    public EmployeeAlreadyAddedException() {
        super();
    }
}
