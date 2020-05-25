package com.moviesfan.test.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpErrorMessage {
    private int code;
    private String message;
    private String auxMessage;
}
