package ru.skypro.lesson.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;
import ru.skypro.lesson.springboot.EmployeeApplication.service.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/salary/sum")
    public int getSumOfSalary() {
        return employeeService.getSumOfSalary();
    }

    @GetMapping("/salary/min")
    public Employee getEmployeeWithMinSalary() {
        return employeeService.getEmployeeWithMinSalary();
    }

    @GetMapping("/salary/max")
    public Employee getEmployeeWithMaxSalary() {
        return employeeService.getEmployeeWithMaxSalary();
    }

    @GetMapping("/high-salary")
    public List<Employee> getHighSalary() {
        return employeeService.getHighSalary();
    }

    @PostMapping()
    public void createEmployees(@RequestBody List<Employee> employees) {
        employeeService.addEmployees(employees);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/{id}")
    public void changeEmployeeById(@RequestBody Employee employee, @PathVariable int id) {
        employeeService.editEmployee(employee, id);
    }

}
