package ru.skypro.lesson.springboot.EmployeeApplication.service;

import org.springframework.core.io.Resource;

import java.io.File;

public interface ReportService {
    int generateReport();
    Resource createReportById(int id);
    File findReportFile(int id);
}
