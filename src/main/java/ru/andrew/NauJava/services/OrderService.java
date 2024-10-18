package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.models.User;

import java.util.List;

public interface OrderService {
    void createOrder(User user, List<Item> items, Double fullPrice);
    Order findById(Long id);
    void deleteById(Long id);
    void updateOrder(Long id, List<Item> items, Double fullPrice);
}
