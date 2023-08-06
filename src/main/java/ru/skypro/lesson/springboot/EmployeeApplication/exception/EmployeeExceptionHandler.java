package ru.skypro.lesson.springboot.EmployeeApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleIOException(IOException ioException) {
        String massage = "Check input again!";
        return new ResponseEntity<>(massage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
        String massage = "Are you sure?";
        return new ResponseEntity<>(massage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        String massage = "Employee not found!";
        return new ResponseEntity<>(massage, HttpStatus.NOT_FOUND);
    }

}
