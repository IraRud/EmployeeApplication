package ru.skypro.lesson.springboot.EmployeeApplication.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lesson.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;
import ru.skypro.lesson.springboot.EmployeeApplication.projection.EmployeeFullInfo;

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
    List<EmployeeDTO> getEmployeesWithPosition(String position);
    EmployeeFullInfo getFullInfoById(int id);
    List<EmployeeDTO> getEmployeesWithPositionByPage(int page);
    void uploadFile(MultipartFile file);
}
