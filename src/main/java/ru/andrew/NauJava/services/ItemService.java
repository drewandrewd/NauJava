package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.Item;

import java.util.List;

/**
 * Интерфейс для сервиса управления товарами.
 */
public interface ItemService {

    /**
     * Создает новый товар с указанными характеристиками.
     *
     * @param name        название товара
     * @param description описание товара
     * @param weight      вес товара
     * @param price       цена товара
     */
    void createItem(String name, String description, Integer weight, Double price);

    /**
     * Находит товар по идентификатору.
     *
     * @param id идентификатор товара
     * @return объект {@link Item}, если найден; null, если товар не найден
     */
    Item findById(Long id);

    /**
     * Удаляет товар по идентификатору.
     *
     * @param id идентификатор товара
     */
    void deleteById(Long id);

    /**
     * Обновляет существующий товар с новыми характеристиками.
     *
     * @param id          идентификатор товара
     * @param name        новое название товара
     * @param description новое описание товара
     * @param weight      новый вес товара
     * @param price       новая цена товара
     */
    void updateItem(Long id, String name, String description, Integer weight, Double price);

    /**
     * Возвращает список всех товаров.
     *
     * @return список объектов {@link Item}
     */
    List<Item> getAllItems();
}
