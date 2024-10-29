package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.models.User;

import java.util.List;

public interface UserService {
    void createUser(String userName, String password, List<String> roles);
    User findById(Long id);
    void deleteById(Long id);
}
