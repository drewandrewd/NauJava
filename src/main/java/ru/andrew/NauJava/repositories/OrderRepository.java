package ru.andrew.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.andrew.NauJava.models.Order;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {


    @Override
    <S extends Order> S save(S entity);

    @Override
    Optional<Order> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
