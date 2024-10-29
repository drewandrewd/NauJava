package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.models.Role;
import ru.andrew.NauJava.models.User;

import java.util.List;

public interface RoleService {
    void createRole(String name);
    void deleteById(Long id);
    List<Role> getAllRoles();
}
