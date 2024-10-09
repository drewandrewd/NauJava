package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.Order;

import java.util.List;

public interface ItemService {
    Long createItem(String name, String description, Integer weight, Double price);
    Item findByName(String name);
    void deleteByName(String name);
    void updateItem(String name, String description, Integer weight, Double price);
    List<Item> getAllItems();
}
