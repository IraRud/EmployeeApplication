package ru.skypro.lesson.springboot.EmployeeApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private final int id;
    private String name;
    private int salary;
}
