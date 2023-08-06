package ru.skypro.lesson.springboot.EmployeeApplication.service;

import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;

import java.util.List;

public interface EmployeeService {

    int getSumOfSalary();
    Employee getEmployeeWithMinSalary();
    Employee getEmployeeWithMaxSalary();
    List<Employee> getHighSalary();
    void addEmployees(List<Employee> employees);
    Employee getEmployeeById(int id);
    void deleteEmployeeById(int id);
    void editEmployee(Employee employee, int id);
    List<Employee> getSalaryHigherThan(int salary);

}
