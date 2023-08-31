package ru.skypro.lesson.springboot.EmployeeApplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Report;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer> {
}
