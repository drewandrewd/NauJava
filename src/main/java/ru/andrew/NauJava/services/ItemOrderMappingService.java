package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.ItemOrderMapping;
import ru.andrew.NauJava.models.Order;

import java.util.List;

public interface ItemOrderMappingService {
    void create(Item item, Order order, Integer quantity);
    ItemOrderMapping findById(Long id);
    void deleteById(Long id);
    void update(Long id, Item item, Order order, Integer quantity);
}
