package ru.skypro.lesson.springboot.EmployeeApplication.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    private final List<Employee> employees = List.of(
            new Employee("Ned Stark", 250_000),
            new Employee("Jaime Lannister", 500_000),
            new Employee("Daenerys Targaryen", 100_000),
            new Employee("Jon Snow", 1_000_000),
            new Employee("Sansa Stark", 200_000)
    );

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

}
