package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.Order;

import java.util.List;

public interface OrderService {
    Long createUser(String userName, List<String> items);
    Order findById(Long id);
    void deleteById(Long id);
    void updateOrder(Long id, List<String> items);
}
