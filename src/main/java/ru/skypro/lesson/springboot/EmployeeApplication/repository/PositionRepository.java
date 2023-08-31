package ru.skypro.lesson.springboot.EmployeeApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Integer>, PagingAndSortingRepository<Position, Integer> {
}
