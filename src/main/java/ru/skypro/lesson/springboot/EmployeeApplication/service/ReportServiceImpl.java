package ru.skypro.lesson.springboot.EmployeeApplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.skypro.lesson.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Report;
import ru.skypro.lesson.springboot.EmployeeApplication.repository.EmployeeRepository;
import ru.skypro.lesson.springboot.EmployeeApplication.repository.ReportRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final EmployeeRepository employeeRepository;
    private final ReportRepository reportRepository;
    private final ObjectMapper objectMapper;

    @Override
    public int generateReport() {
        List<ReportDTO> report = employeeRepository.buildReport();
        try {

            String content = objectMapper.writeValueAsString(report);
            String path = generateReportFile(content);

            Report reportEntity = new Report();
            reportEntity.setReport(content);
            reportEntity.setPath(path);
            return reportRepository.save(reportEntity).getId();
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Cannot generate report", e);
        }
    }

    public String generateReportFile(String content){
        File file = new File("report_" + System.currentTimeMillis() + ".json");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (IOException e) {
            throw new UncheckedIOException("Cannot generate report file", e);
        }
        return file.getName();
    }

    @Override
    public Resource createReportById(int id) {
        return new ByteArrayResource(
                reportRepository.findById(id)
                        .orElseThrow(() -> new IllegalStateException("Report with id " + id + " not found"))
                        .getReport()
                        .getBytes(StandardCharsets.UTF_8)
        );
    }

    @Override
    public File findReportFile(int id) {
        return reportRepository.findById(id)
                .map(Report::getPath)
                .map(File::new)
                .orElse(null);
    }
}
