package ru.skypro.lesson.springboot.EmployeeApplication.security;

import org.springframework.security.core.GrantedAuthority;
import ru.skypro.lesson.springboot.EmployeeApplication.security.model.UserRole;

public class SecurityGrantedAuthorities implements GrantedAuthority {
    private String role;

    public SecurityGrantedAuthorities(UserRole userRole) {
        this.role = userRole.getRoles();
    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}
