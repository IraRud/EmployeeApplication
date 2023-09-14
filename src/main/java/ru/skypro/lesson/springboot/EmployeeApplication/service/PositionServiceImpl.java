package ru.skypro.lesson.springboot.EmployeeApplication.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.skypro.lesson.springboot.EmployeeApplication.dto.PositionDTO;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Position;
import ru.skypro.lesson.springboot.EmployeeApplication.repository.PositionRepository;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public void addPosition(Position position) {
        logger.debug("Was invoked method for add position");
        positionRepository.save(position);
    }

    @Override
    public PositionDTO getPositionById(int id) {
        logger.debug("Was invoked method for get position by {} id ", id);
        Position position = positionRepository.findById(id).get();
        return PositionDTO.fromPosition(position);
    }

    @Override
    public void deletePositionById(int id) {
        logger.debug("Was invoked method for delete position by {} id ", id);
        positionRepository.deleteById(id);
    }
}
