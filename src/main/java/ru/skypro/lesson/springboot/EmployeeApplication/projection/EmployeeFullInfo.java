package ru.skypro.lesson.springboot.EmployeeApplication.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmployeeFullInfo {
    private String name;
    private Integer salary;
    private String positionName;
}
