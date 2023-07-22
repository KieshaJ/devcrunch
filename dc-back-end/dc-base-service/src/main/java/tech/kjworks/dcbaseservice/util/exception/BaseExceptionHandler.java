package tech.kjworks.dcbaseservice.util.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

public class BaseExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> badRequest(MethodArgumentNotValidException ex,
        HttpServletRequest request) {
        Error error = new Error(
            ex.getMessage(),
            HttpStatus.BAD_REQUEST.value(),
            new Date().getTime()
        );
        return new ResponseEntity<>(error, null, HttpStatus.BAD_REQUEST);
    }
}
