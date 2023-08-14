package ru.skypro.lesson.springboot.EmployeeApplication.service;

import ru.skypro.lesson.springboot.EmployeeApplication.dto.PositionDTO;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Position;

public interface PositionService {
    void addPosition(Position position);
    PositionDTO getPositionById(int id);
    void deletePositionById(int id);
}
