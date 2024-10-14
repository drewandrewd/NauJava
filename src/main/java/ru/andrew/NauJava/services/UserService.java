package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.models.User;

import java.util.List;

public interface UserService {
    String createUser(String userName);
    User findById(Long id);
    void deleteById(Long id);
}
