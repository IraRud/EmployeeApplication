package ru.skypro.lesson.springboot.EmployeeApplication.repository;

import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> getAllEmployees();
    void addEmployees(List<Employee> employees);
    void deleteEmployeeById(int id);

}
