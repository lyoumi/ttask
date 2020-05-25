package com.moviesfan.test.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private int code;
    private String message;
    private String auxMessage;
    private HttpStatus httpStatus;
}
