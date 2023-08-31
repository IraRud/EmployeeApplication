package ru.skypro.lesson.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lesson.springboot.EmployeeApplication.service.ReportService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("report")
public class ReportController {
    private final ReportService reportService;

    @PostMapping()
    public int getReport() {
        return reportService.generateReport();
    }

    @GetMapping("{id}")
    public ResponseEntity<Resource> getReportById(@PathVariable int id) {
        Resource resource = reportService.createReportById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"reportById.json\"")
                .body(resource);
    }

    @GetMapping("part_2/{id}")
    public ResponseEntity<Resource> findAndGetFile(@PathVariable int id) {
        File file = reportService.findReportFile(id);
        if (file == null) {
            return ResponseEntity.noContent().build();
        }
        try {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.json")
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (FileNotFoundException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
