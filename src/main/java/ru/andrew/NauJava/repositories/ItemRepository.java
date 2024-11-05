package ru.andrew.NauJava.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.andrew.NauJava.models.Item;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторий для работы с сущностями {@link Item}.
 * Предоставляет методы для выполнения операций с товарами в базе данных.
 */
@RepositoryRestResource
public interface ItemRepository extends CrudRepository<Item, String> {

    /**
     * Сохраняет указанный товар в базе данных.
     *
     * @param entity товар, который нужно сохранить
     * @param <S> тип товара
     * @return сохранённый товар
     */
    @Override
    <S extends Item> S save(S entity);

    /**
     * Находит товар по его идентификатору.
     *
     * @param s идентификатор товара
     * @return {@link Optional} с найденным товаром, если такой существует; иначе пустой {@link Optional}
     */
    @Override
    Optional<Item> findById(String s);

    /**
     * Удаляет товар по его идентификатору.
     *
     * @param s идентификатор товара, который нужно удалить
     */
    @Override
    void deleteById(String s);

    /**
     * Находит все товары в базе данных.
     *
     * @return список всех товаров
     */
    @Override
    List<Item> findAll();
}
