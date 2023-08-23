package ru.skypro.lesson.springboot.EmployeeApplication.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.skypro.lesson.springboot.EmployeeApplication.dto.ReportDTO;
import ru.skypro.lesson.springboot.EmployeeApplication.projection.EmployeeFullInfo;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;

import java.util.List;

@Repository
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

    @Query("SELECT new ru.skypro.lesson.springboot.EmployeeApplication.dto." +
            "ReportDTO (e.position.name, count(e.id), max(e.salary), min(e.salary), avg(e.salary)) " +
            "FROM Employee e " +
            "GROUP BY e.position.name")
    List<ReportDTO> buildReport();
}
