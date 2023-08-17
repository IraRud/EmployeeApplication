package ru.skypro.lesson.springboot.EmployeeApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Position;

public interface PositionRepository extends CrudRepository<Position, Integer>, PagingAndSortingRepository<Position, Integer> {

}
