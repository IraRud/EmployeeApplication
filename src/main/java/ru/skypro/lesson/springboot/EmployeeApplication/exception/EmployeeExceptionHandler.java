package ru.skypro.lesson.springboot.EmployeeApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> handleRuntimeException(RuntimeException exception) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleIOException(IOException ioException) {
        String massage = "Employee not found";
        return new ResponseEntity<>(massage, HttpStatus.NOT_FOUND);
    }
}
