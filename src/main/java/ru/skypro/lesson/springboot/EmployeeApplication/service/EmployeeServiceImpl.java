package ru.skypro.lesson.springboot.EmployeeApplication.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lesson.springboot.EmployeeApplication.dto.EmployeeDTO;
import ru.skypro.lesson.springboot.EmployeeApplication.projection.EmployeeFullInfo;
import ru.skypro.lesson.springboot.EmployeeApplication.exception.EmployeeNotFoundException;
import ru.skypro.lesson.springboot.EmployeeApplication.model.Employee;
import ru.skypro.lesson.springboot.EmployeeApplication.repository.EmployeeRepository;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper;
    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public int getSumOfSalary() {
        logger.debug("Was invoked method for get the amount of employees' salaries");
        return employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .mapToInt(EmployeeDTO::getSalary)
                .sum();
    }

    @Override
    public EmployeeDTO getEmployeeWithMinSalary() {
        logger.debug("Was invoked method for get employee with min salary");
        return employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .min(Comparator.comparingInt(EmployeeDTO::getSalary))
                .orElseThrow(() -> {
                    logger.error("Employee with min salary is not found");
                    return new EmployeeNotFoundException();
                });
    }

    @Override
    public EmployeeDTO getEmployeeWithMaxSalary() {
        logger.debug("Was invoked method for get employee with max salary");
        return employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .max(Comparator.comparingInt(EmployeeDTO::getSalary))
                .orElseThrow(() -> {
                    logger.error("Employee with max salary is not found");
                    return new EmployeeNotFoundException();
                });
    }

    @Override
    public List<EmployeeDTO> getHighSalary() {
        logger.debug("Was invoked method for get employees with salaries above the average");

        double average = employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .mapToInt(EmployeeDTO::getSalary)
                .average()
                .getAsDouble();

        return employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .filter(employeeDTO -> employeeDTO.getSalary() > average)
                .toList();
    }

    @Override
    public void addEmployees(List<Employee> employeeList) {
        logger.debug("Was invoked method for create employees");
        employeeRepository.saveAll(employeeList);
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        logger.debug("Was invoked method for get employee by {} id", id);
        try {
            Employee employee = employeeRepository.findById(id).get();
            return EmployeeDTO.fromEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            logger.error("Employee with id = " + id + " not found" + e);
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public void deleteEmployeeById(int id) {
        logger.debug("Was invoked method for delete employee by {} id", id);
        employeeRepository.deleteById(id);
    }

    @Override
    public void editEmployee(Employee employee, int id) {
        logger.debug("Was invoked method for save employee by {} id", id);
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> getSalaryHigherThan(int salary) {
        logger.debug("Was invoked method for get employee with salary higher than " + salary);
        return employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .filter(employee -> employee.getSalary() > salary)
                .toList();
    }

    @Override
    public List<EmployeeDTO> getEmployeesWithHighestSalary() {
        logger.debug("Was invoked method for get employee with highest salary");
        return employeeRepository.getEmployeesWithHighestSalary().stream()
                .map(EmployeeDTO::fromEmployee)
                .toList();
    }

    @Override
    public List<EmployeeDTO> getEmployeesWithPosition(String position) {
        logger.debug("Was invoked method for get employee with position" + position);
        List<EmployeeDTO> employeeDTOList = employeeRepository.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .filter(employee -> employee.getPosition().getName().equals(position))
                .toList();

        return employeeDTOList.isEmpty() ?
                employeeRepository.getAllEmployees().stream()
                        .map(EmployeeDTO::fromEmployee)
                        .toList()
                : employeeDTOList;
    }

    @Override
    public EmployeeFullInfo getFullInfoById(int id) {
        logger.debug("Was invoked method for get full info of employee by id " + id);
        return Optional.ofNullable(employeeRepository.getFullInfoById(id))
                .orElseThrow(() -> {
                    logger.error("Employee is not found");
                    return new EmployeeNotFoundException();
                });
    }

    @Override
    public List<EmployeeDTO> getEmployeesWithPositionByPage(int pageIndex) {
        logger.debug("Was invoked method for get employees with position by page = " + pageIndex);

        int unitPerPage = 10;

        Pageable employeeOfConcretePage = PageRequest.of(pageIndex, unitPerPage);
        Page<Employee> page = employeeRepository.findAll(employeeOfConcretePage);

        return page.stream()
                .map(EmployeeDTO::fromEmployee)
                .toList();
    }

    @Override
    public void uploadFile(MultipartFile file) {
        logger.debug("Was invoked method for upload file");
        try {
            List<EmployeeDTO> employeeDTOList = objectMapper.readValue(file.getBytes(), new TypeReference<>() {
            });
            employeeDTOList.stream()
                    .map(EmployeeDTO::toEmployee)
                    .forEach(employeeRepository::save);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
