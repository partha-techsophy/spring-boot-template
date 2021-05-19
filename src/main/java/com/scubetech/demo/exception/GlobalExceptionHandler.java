package com.scubetech.demo.exception;

import com.scubetech.demo.application.response.ApiErrorResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.Locale;

/**
 * Global error handler. Any error at the controller level will be captured by @RestControllerAdvice.
 *
 */
@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ApiErrorResponse> invalidInputException(InvalidInputException ex, WebRequest request) {

        ApiErrorResponse errorDetails = new ApiErrorResponse(Instant.now(), getMessage(ex.getMessage(), null, request.getLocale()), ex.getMessage(),
                HttpStatus.BAD_REQUEST, request.getDescription(false));

       return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<ApiErrorResponse> invalidEmailException(InvalidEmailException ex, WebRequest request) {
        ApiErrorResponse errorDetails = new ApiErrorResponse(Instant.now(), getMessage(ex.getMessage(), null, request.getLocale()), ex.getMessage(),
                HttpStatus.BAD_REQUEST, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ApiErrorResponse errorDetails = new ApiErrorResponse(Instant.now(), getMessage(ex.getMessage(), null, request.getLocale()), ex.getMessage(),
                HttpStatus.NOT_FOUND, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> userNotFoundException(UserNotFoundException ex, WebRequest request) {
        ApiErrorResponse errorDetails = new ApiErrorResponse(Instant.now(), getMessage(ex.getMessage(), null, request.getLocale()), ex.getMessage(),
                HttpStatus.NOT_FOUND, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> globalExceptionHandler(Exception ex, WebRequest request) {
        ApiErrorResponse errorDetails = new ApiErrorResponse(Instant.now(), getMessage(ex.getMessage(), null, request.getLocale()), ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR, request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getMessage(String errorCode, String[] args, Locale locale) {
        return messageSource.getMessage(errorCode, args, locale);
    }
}
