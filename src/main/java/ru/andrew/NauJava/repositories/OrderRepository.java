package ru.andrew.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.andrew.NauJava.models.Order;

import java.util.Optional;

/**
 * Репозиторий для работы с сущностями {@link Order}.
 * Предоставляет методы для выполнения операций с заказами в базе данных.
 */
@RepositoryRestResource
public interface OrderRepository extends CrudRepository<Order, Long> {

    /**
     * Сохраняет указанный заказ в базе данных.
     *
     * @param entity заказ, который нужно сохранить
     * @param <S> тип заказа
     * @return сохранённый заказ
     */
    @Override
    <S extends Order> S save(S entity);

    /**
     * Находит заказ по его идентификатору.
     *
     * @param aLong идентификатор заказа
     * @return {@link Optional} с найденным заказом, если такой существует; иначе пустой {@link Optional}
     */
    @Override
    Optional<Order> findById(Long aLong);

    /**
     * Удаляет заказ по его идентификатору.
     *
     * @param aLong идентификатор заказа, который нужно удалить
     */
    @Override
    void deleteById(Long aLong);
}
