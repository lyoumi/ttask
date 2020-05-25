package com.moviesfan.test.exception;

public class UnableToUpdateFavoriteMoviesException extends RuntimeException {

    public UnableToUpdateFavoriteMoviesException(String message) {
        super(message);
    }
}
