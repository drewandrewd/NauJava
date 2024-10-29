package ru.andrew.NauJava.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.ItemOrderMapping;

import java.util.Optional;

@RepositoryRestResource
public interface ItemOrderMappingRepositoryCustom {
    ItemOrderMapping save(ItemOrderMapping entity);

    ItemOrderMapping findById(String s);

    void deleteById(String s);
}
