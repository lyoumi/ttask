package com.moviesfan.test.exception;

public class UnableToUpdateFavoriteActorsException extends RuntimeException {

    public UnableToUpdateFavoriteActorsException(String message) {
        super(message);
    }
}
