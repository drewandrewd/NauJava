package ru.andrew.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.andrew.NauJava.models.Item;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface ItemRepository extends CrudRepository<Item, String> {
    @Override
    <S extends Item> S save(S entity);

    @Override
    Optional<Item> findById(String s);

    @Override
    void deleteById(String s);

    @Override
    List<Item> findAll();
}
