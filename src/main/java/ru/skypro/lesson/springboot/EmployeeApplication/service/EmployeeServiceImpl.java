package ru.skypro.lesson.springboot.EmployeeApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.lesson.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lesson.springboot.EmployeeApplication.projection.EmployeeFullInfo;
import ru.skypro.lesson.springboot.EmployeeApplication.exception.EmployeeNotFoundException;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;
import ru.skypro.lesson.springboot.EmployeeApplication.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public int getSumOfSalary() {
        return employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .mapToInt(EmployeeDTO::getSalary)
                .sum();
    }

    @Override
    public EmployeeDTO getEmployeeWithMinSalary() {
        return employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .min(Comparator.comparingInt(EmployeeDTO::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public EmployeeDTO getEmployeeWithMaxSalary() {
        return employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .max(Comparator.comparingInt(EmployeeDTO::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<EmployeeDTO> getHighSalary() {
        double average = employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .mapToInt(EmployeeDTO::getSalary)
                .average()
                .getAsDouble();

        return employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .filter(employeeDTO -> employeeDTO.getSalary() > average)
                .toList();
    }

    @Override
    public void addEmployees(List<Employee> employeeList) {
        employeeRepository.saveAll(employeeList);
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        Employee employee = employeeRepository.findById(id).get();
        return EmployeeDTO.fromEmployee(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void editEmployee(Employee employee, int id) {
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> getSalaryHigherThan(int salary) {
        return employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .filter(employee -> employee.getSalary() > salary)
                .toList();
    }

    @Override
    public List<EmployeeDTO> getEmployeesWithHighestSalary() {
        return employeeRepository.getEmployeesWithHighestSalary().stream()
                .map(EmployeeDTO::fromEmployee)
                .toList();
    }

    @Override
    public List<EmployeeDTO> getEmployeesWithPosition(String position) {
        List<EmployeeDTO> employeeDTOList = employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .filter(employee -> employee.getPosition().getName().equals(position))
                .toList();

        return employeeDTOList.isEmpty() ?
                employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .toList()
                : employeeDTOList;
    }

    @Override
    public EmployeeFullInfo getFullInfoById(int id) {
        return Optional.ofNullable(employeeRepository.getFullInfoById(id)).orElseThrow(EmployeeNotFoundException::new);
    }
}
