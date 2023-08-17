package ru.skypro.lesson.springboot.EmployeeApplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lesson.springboot.EmployeeApplication.dto.PositionDTO;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Position;
import ru.skypro.lesson.springboot.EmployeeApplication.service.PositionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("position")
public class PositionController {
    private final PositionService positionService;

    @PostMapping()
    public void createPosition(@RequestBody Position position) {
        positionService.addPosition(position);
    }

    @GetMapping("/{id}")
    public PositionDTO getPositionById(@PathVariable int id) {
        return positionService.getPositionById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePositionById(@PathVariable int id) {
        positionService.deletePositionById(id);
    }

}
