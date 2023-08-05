package ru.skypro.lesson.springboot.EmployeeApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.lesson.springboot.EmployeeApplication.exception.EmployeeNotFoundException;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;
import ru.skypro.lesson.springboot.EmployeeApplication.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public int getSumOfSalary() {
        return employeeRepository.getAllEmployees().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public Employee getEmployeeWithMinSalary() {
        return employeeRepository.getAllEmployees().stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getEmployeeWithMaxSalary() {
        return employeeRepository.getAllEmployees().stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> getHighSalary() {
        double average = employeeRepository.getAllEmployees().stream()
                .mapToInt(Employee::getSalary)
                .average()
                .getAsDouble();

        return employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getSalary() > average)
                .toList();
    }

    @Override
    public void addEmployees(List<Employee> employees) {
        employeeRepository.addEmployees(employees);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getAllEmployees().stream()
                .filter(employee -> employee.getId() == id)
                .findAny()
                .get();
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteEmployeeById(id);
    }

}
