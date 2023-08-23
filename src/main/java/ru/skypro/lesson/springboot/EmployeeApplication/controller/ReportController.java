package ru.skypro.lesson.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lesson.springboot.EmployeeApplication.service.ReportServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("report")
public class ReportController {
    private final ReportServiceImpl reportService;

    @PostMapping()
    public int getReport() {
        return reportService.generateReport();
    }
}
