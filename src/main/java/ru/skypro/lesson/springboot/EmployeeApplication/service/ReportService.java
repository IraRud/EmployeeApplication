package ru.skypro.lesson.springboot.EmployeeApplication.service;

import org.springframework.core.io.Resource;

import java.io.File;

public interface ReportService {
    int generateReport();
    Resource generateReportById(int id);
    File findReportFile(int id);
}
