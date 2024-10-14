package ru.andrew.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.andrew.NauJava.models.Item;

import java.util.Optional;


public interface ItemRepository extends CrudRepository<Item, String> {
    @Override
    <S extends Item> S save(S entity);

    @Override
    Optional<Item> findById(String s);

    @Override
    void deleteById(String s);
}
