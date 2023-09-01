package ru.skypro.lesson.springboot.EmployeeApplication.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.lesson.springboot.EmployeeApplication.security.model.AuthUser;

public interface UserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findByUsername(String username);
}
