package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.Order;

import java.util.List;

public interface ItemService {
    Long createItem(String name, String description, Integer weight, Double price);
    Item findById(Long id);
    void deleteById(Long id);
    void updateItem(Long id, String name, String description, Integer weight, Double price);
    List<Item> getAllItems();
}
