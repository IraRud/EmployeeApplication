package ru.skypro.lesson.springboot.EmployeeApplication.service;

import ru.skypro.lesson.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;

import java.util.List;

public interface EmployeeService {
    int getSumOfSalary();
    EmployeeDTO getEmployeeWithMinSalary();
    EmployeeDTO getEmployeeWithMaxSalary();
    List<EmployeeDTO> getHighSalary();
    void addEmployees(List<Employee> employees);
    EmployeeDTO getEmployeeById(int id);
    void deleteEmployeeById(int id);
    void editEmployee(Employee employee, int id);
    List<EmployeeDTO> getSalaryHigherThan(int salary);
    List<EmployeeDTO> getEmployeesWithHighestSalary();
}
