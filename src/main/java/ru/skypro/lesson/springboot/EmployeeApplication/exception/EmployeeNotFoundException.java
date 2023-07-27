package ru.skypro.lesson.springboot.EmployeeApplication.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Employee not found";

    public EmployeeNotFoundException(String DEFAULT_MESSAGE) {
        super(DEFAULT_MESSAGE);
    }

}
