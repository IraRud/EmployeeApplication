package ru.skypro.lesson.springboot.EmployeeApplication.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.skypro.lesson.springboot.EmployeeApplication.projection.EmployeeFullInfo;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>, PagingAndSortingRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM employee ",
            nativeQuery = true)
    List<Employee> getAllEmployees();

    @Query(value = "SELECT * FROM employee WHERE salary = (SELECT MAX(salary) FROM employee)",
            nativeQuery = true)
    List<Employee> getEmployeesWithHighestSalary();

    @Query("SELECT new ru.skypro.lesson.springboot.EmployeeApplication.projection." +
            "EmployeeFullInfo(e.name , e.salary , p.name) " +
            "FROM Employee e join fetch Position p " +
            "ON e.position = p " +
            "WHERE e.id = :id")
    EmployeeFullInfo getFullInfoById(@Param("id") Integer id);
}
