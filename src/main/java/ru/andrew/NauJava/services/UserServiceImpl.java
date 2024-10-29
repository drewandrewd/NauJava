package ru.andrew.NauJava.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.andrew.NauJava.config.SpringSecurityConfig;
import ru.andrew.NauJava.models.Role;
import ru.andrew.NauJava.models.User;
import ru.andrew.NauJava.repositories.RoleRepository;
import ru.andrew.NauJava.repositories.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final SpringSecurityConfig springSecurityConfig;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, SpringSecurityConfig springSecurityConfig) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.springSecurityConfig = springSecurityConfig;
    }

    @PostConstruct
    public void init() {
        User user = new User();
        user.setName("admin");
        user.setPassword(springSecurityConfig.getPasswordEncoder().encode("admin"));
        user.setRoles(Set.of(Role.createWithName("ADMIN")));
        userRepository.save(user);
    }

    @Override
    public void createUser(String userName, String password, List<String> roleNames) {
        User user = new User();
        user.setName(userName);
        user.setPassword(springSecurityConfig.getPasswordEncoder().encode(password));
//        Set<Role> roles = roleNames.stream()
//                .map(roleName -> roleRepository.findByName(roleName)
//                        .orElseGet(() -> roleRepository.save(Role.createWithName(roleName))))
//                .collect(Collectors.toSet());
        user.setRoles(Set.of(roleRepository.findByName("USER").get()));
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
