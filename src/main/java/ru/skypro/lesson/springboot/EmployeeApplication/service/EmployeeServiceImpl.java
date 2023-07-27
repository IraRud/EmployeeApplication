package ru.skypro.lesson.springboot.EmployeeApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;
import ru.skypro.lesson.springboot.EmployeeApplication.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getSumOfSalary() {
        return new Employee("NoName", 12_000);
    }

    @Override
    public Employee getEmployeeWithMinSalary() {
        return null;
    }

    @Override
    public Employee getEmployeeWithMaxSalary() {
        return null;
    }

    @Override
    public List<Employee> getHighSalary() {
        return null;
    }

}
