package com.example.mallelectron.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{

    private Integer status;

    public CustomException(String message, Integer status) {
        super(message);
        this.status = status;
    }

    public CustomException(String message) {
        super(message);
    }
}
