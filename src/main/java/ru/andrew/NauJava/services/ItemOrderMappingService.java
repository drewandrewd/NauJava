package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.ItemOrderMapping;
import ru.andrew.NauJava.models.Order;

/**
 * Интерфейс для управления маппингами товаров и заказов.
 */
public interface ItemOrderMappingService {

    /**
     * Создает новый маппинг между товаром и заказом с указанным количеством.
     *
     * @param item     товар, который будет связан с заказом
     * @param order    заказ, с которым будет связан товар
     * @param quantity количество товара в заказе
     */
    void create(Item item, Order order, Integer quantity);

    /**
     * Находит маппинг товара и заказа по идентификатору.
     *
     * @param id идентификатор маппинга
     * @return объект {@link ItemOrderMapping}, если найден; null, если маппинг не найден
     */
    ItemOrderMapping findById(Long id);

    /**
     * Удаляет маппинг товара и заказа по идентификатору.
     *
     * @param id идентификатор маппинга, который нужно удалить
     */
    void deleteById(Long id);

    /**
     * Обновляет существующий маппинг товара и заказа с новыми данными.
     *
     * @param id       идентификатор маппинга
     * @param item     новый товар для обновления
     * @param order    новый заказ для обновления
     * @param quantity новое количество товара в заказе
     */
    void update(Long id, Item item, Order order, Integer quantity);
}
