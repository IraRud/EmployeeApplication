package ru.skypro.lesson.springboot.EmployeeApplication.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>(
            List.of(
                    new Employee(1, "Ned Stark", 250_000),
                    new Employee(2, "Jaime Lannister", 500_000),
                    new Employee(3, "Daenerys Targaryen", 100_000),
                    new Employee(4, "Jon Snow", 1_000_000),
                    new Employee(5, "Sansa Stark", 200_000))
    );

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    @Override
    public void addEmployees(List<Employee> employeeList) {
        employees.addAll(employeeList);
    }

    @Override
    public void deleteEmployeeById(int id) {
        Employee employeeDeleted = employees.stream()
                .filter(employee -> employee.getId() == id)
                .findAny()
                .get();

        this.employees.remove(employeeDeleted);
    }

}
