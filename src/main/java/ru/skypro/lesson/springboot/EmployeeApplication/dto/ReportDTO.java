package ru.skypro.lesson.springboot.EmployeeApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportDTO {
    private String position;
    private long count;
    private int maxSalary;
    private int minSalary;
    private double averageSalary;
}
