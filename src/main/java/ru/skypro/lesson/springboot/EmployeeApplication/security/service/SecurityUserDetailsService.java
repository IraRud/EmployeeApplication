package ru.skypro.lesson.springboot.EmployeeApplication.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skypro.lesson.springboot.EmployeeApplication.security.SecurityUserPrincipal;
import ru.skypro.lesson.springboot.EmployeeApplication.security.model.AuthUser;
import ru.skypro.lesson.springboot.EmployeeApplication.security.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new SecurityUserPrincipal(user);
    }
}
