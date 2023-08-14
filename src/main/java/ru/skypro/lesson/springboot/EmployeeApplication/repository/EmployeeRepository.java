package ru.skypro.lesson.springboot.EmployeeApplication.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>, PagingAndSortingRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM employee ",
            nativeQuery = true)
    List<Employee> getAllEmployees();

    @Query(value = "SELECT * FROM employee WHERE salary = (SELECT MAX(salary) FROM employee)",
            nativeQuery = true)
    List<Employee> getEmployeesWithHighestSalary();
}
