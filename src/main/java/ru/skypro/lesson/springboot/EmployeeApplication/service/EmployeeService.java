package ru.skypro.lesson.springboot.EmployeeApplication.service;

import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getSumOfSalary();
    Employee getEmployeeWithMinSalary();
    Employee getEmployeeWithMaxSalary();
    List<Employee> getHighSalary();

}
