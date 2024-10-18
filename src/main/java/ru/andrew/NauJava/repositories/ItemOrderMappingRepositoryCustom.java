package ru.andrew.NauJava.repositories;

import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.ItemOrderMapping;

import java.util.Optional;

public interface ItemOrderMappingRepositoryCustom {
    ItemOrderMapping save(ItemOrderMapping entity);

    ItemOrderMapping findById(String s);

    void deleteById(String s);
}
