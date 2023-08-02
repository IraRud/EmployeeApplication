package ru.skypro.lesson.springboot.EmployeeApplication.repository;

import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    public List<Employee> getAllEmployees();

}
