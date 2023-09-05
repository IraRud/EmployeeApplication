package ru.skypro.lesson.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;
import ru.skypro.lesson.springboot.EmployeeApplication.service.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/employee")
public class AdminEmployeeController {
    private final EmployeeService employeeService;

    @PostMapping()
    public void createEmployees(@RequestBody List<Employee> employees) {
        employeeService.addEmployees(employees);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/{id}")
    public void changeEmployeeById(@RequestBody Employee employee, @PathVariable int id) {
        employeeService.editEmployee(employee, id);
    }

    @PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(@RequestPart("employees") MultipartFile file) {
        employeeService.uploadFile(file);
    }
}
