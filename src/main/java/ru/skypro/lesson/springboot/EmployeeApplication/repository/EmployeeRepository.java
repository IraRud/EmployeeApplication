package ru.skypro.lesson.springboot.EmployeeApplication.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>, PagingAndSortingRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM Employee ",
            nativeQuery = true)
    List<Employee> getAllEmployees();

    @Override
    Optional<Employee> findById(Integer integer);

    @Override
    void deleteById(Integer id);

    @Override
    Employee save(Employee entity);
}
