package ru.skypro.lesson.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lesson.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lesson.springboot.EmployeeApplication.projection.EmployeeFullInfo;
import ru.skypro.lesson.springboot.EmployeeApplication.service.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/salary/sum")
    public int getSumOfSalary() {
        return employeeService.getSumOfSalary();
    }

    @GetMapping("/salary/min")
    public EmployeeDTO getEmployeeWithMinSalary() {
        return employeeService.getEmployeeWithMinSalary();
    }

    @GetMapping("/salary/max")
    public EmployeeDTO getEmployeeWithMaxSalary() {
        return employeeService.getEmployeeWithMaxSalary();
    }

    @GetMapping("/high-salary")
    public List<EmployeeDTO> getHighSalary() {
        return employeeService.getHighSalary();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/salaryHigherThan")
    public List<EmployeeDTO> getEmployeesWithSalaryHigherThan(@RequestParam("salary") int salary) {
        return employeeService.getSalaryHigherThan(salary);
    }

    @GetMapping("withHighestSalary")
    public List<EmployeeDTO> getEmployeesWithHighestSalary() {
        return employeeService.getEmployeesWithHighestSalary();
    }

    @GetMapping()
    public List<EmployeeDTO> getEmployeesWithPosition(@RequestParam("position") String position) {
        return employeeService.getEmployeesWithPosition(position);
    }

    @GetMapping("/{id}/fullInfo")
    public EmployeeFullInfo getFullInfoById(@PathVariable int id) {
        return employeeService.getFullInfoById(id);
    }

    @GetMapping("page")
    public List<EmployeeDTO> getEmployeesWithPositionByPage(@RequestParam(required = false, defaultValue = "0", name = "page") int page) {
        return employeeService.getEmployeesWithPositionByPage(page);
    }
}
