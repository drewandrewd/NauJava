package ru.andrew.NauJava.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.Role;
import ru.andrew.NauJava.repositories.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void createRole(String name) {
        Role role = new Role();
        role.setName(name);
        roleRepository.save(role);
    }

    @PostConstruct
    public void init() {
        if (roleRepository.findByName("ADMIN").isEmpty()) {
            roleRepository.save(Role.createWithName("ADMIN"));
        }
        if (roleRepository.findByName("USER").isEmpty()) {
            roleRepository.save(Role.createWithName("USER"));
        }
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles:: add);
        return roles;
    }
}
