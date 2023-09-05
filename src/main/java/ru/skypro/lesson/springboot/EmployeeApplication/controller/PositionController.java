package ru.skypro.lesson.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lesson.springboot.EmployeeApplication.dto.PositionDTO;
import ru.skypro.lesson.springboot.EmployeeApplication.service.PositionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("user/position")
public class PositionController {
    private final PositionService positionService;

    @GetMapping("/{id}")
    public PositionDTO getPositionById(@PathVariable int id) {
        return positionService.getPositionById(id);
    }
}
