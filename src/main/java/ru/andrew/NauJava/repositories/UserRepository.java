package ru.andrew.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.andrew.NauJava.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    @Override
    <S extends User> S save(S entity);

    @Override
    Optional<User> findById(String s);

    @Override
    void deleteById(String s);
}
