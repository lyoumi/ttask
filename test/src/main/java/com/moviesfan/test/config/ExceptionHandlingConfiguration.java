package com.moviesfan.test.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.moviesfan.test.exception.HttpErrorMessage;
import com.moviesfan.test.exception.ErrorMessage;
import com.moviesfan.test.exception.UnableToUpdateFavoriteActorsException;
import com.moviesfan.test.exception.UnableToUpdateFavoriteMoviesException;

import java.util.Map;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class ExceptionHandlingConfiguration extends ResponseEntityExceptionHandler {

    private static final Map<Class<? extends Throwable>, ErrorMessage> ERROR_MAPPING = Map.of(
        UnableToUpdateFavoriteActorsException.class, new ErrorMessage(10050001, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR),
        UnableToUpdateFavoriteMoviesException.class, new ErrorMessage(10050002, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR)
    );

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<HttpErrorMessage> handleException(Exception ex) {
        ResponseEntity<HttpErrorMessage> resolved = buildHttpResponse(ex);
        if (resolved.getStatusCode().is4xxClientError()) {
            log.warn(ex.getMessage(), ex);
        } else if (resolved.getStatusCode().is5xxServerError()) {
            log.error("Exception occurred", ex);
        }
        return resolved;
    }

    private ResponseEntity<HttpErrorMessage> buildHttpResponse(Exception exception) {
        return findErrorMapping(exception.getClass())
            .map(errorMessage -> new ResponseEntity<HttpErrorMessage>(
                new HttpErrorMessage(errorMessage.getCode(),
                    errorMessage.getMessage(),
                    errorMessage.getAuxMessage()),
                errorMessage.getHttpStatus()))
            .orElse(buildDefaultHttpErrorMessage());
    }

    private ResponseEntity<HttpErrorMessage> buildDefaultHttpErrorMessage() {
        return new ResponseEntity<HttpErrorMessage>(new HttpErrorMessage(10050000, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Optional<ErrorMessage> findErrorMapping(Class<? extends Throwable> exceptionType) {
        for (Class<?> exceptionTypeToCheck = exceptionType; exceptionTypeToCheck != Object.class;
            exceptionTypeToCheck = exceptionTypeToCheck.getSuperclass()) {
            ErrorMessage mapping = ERROR_MAPPING.get(exceptionTypeToCheck);
            if (mapping != null) {
                return Optional.of(mapping);
            }
        }
        return Optional.empty();
    }

}
