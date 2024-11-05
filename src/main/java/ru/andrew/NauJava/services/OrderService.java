package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.models.User;

import java.util.List;

/**
 * Интерфейс для сервиса управления заказами.
 */
public interface OrderService {

    /**
     * Создает новый заказ для пользователя с указанными товарами и общей стоимостью.
     *
     * @param user      пользователь, который создает заказ
     * @param items     список товаров в заказе
     * @param fullPrice полная стоимость заказа
     */
    void createOrder(User user, List<Item> items, Double fullPrice);

    /**
     * Находит заказ по идентификатору.
     *
     * @param id идентификатор заказа
     * @return объект {@link Order}, если найден; null, если заказ не найден
     */
    Order findById(Long id);

    /**
     * Удаляет заказ по идентификатору.
     *
     * @param id идентификатор заказа
     */
    void deleteById(Long id);

    /**
     * Обновляет заказ с указанными товарами и общей стоимостью.
     *
     * @param id        идентификатор заказа
     * @param items     новый список товаров
     * @param fullPrice новая полная стоимость заказа
     */
    void updateOrder(Long id, List<Item> items, Double fullPrice);
}
