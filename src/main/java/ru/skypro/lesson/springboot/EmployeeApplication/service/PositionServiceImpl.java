package ru.skypro.lesson.springboot.EmployeeApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.lesson.springboot.EmployeeApplication.dto.PositionDTO;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Position;
import ru.skypro.lesson.springboot.EmployeeApplication.repository.PositionRepository;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    @Override
    public void addPosition(Position position) {
        positionRepository.save(position);
    }

    @Override
    public PositionDTO getPositionById(int id) {
        Position position = positionRepository.findById(id).get();
        return PositionDTO.fromPosition(position);
    }

    @Override
    public void deletePositionById(int id) {
        positionRepository.deleteById(id);
    }
}
