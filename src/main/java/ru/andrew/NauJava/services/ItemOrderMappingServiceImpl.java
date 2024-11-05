package ru.andrew.NauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.ItemOrderMapping;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.repositories.ItemOrderRepositoryImpl;

/**
 * Сервис для управления маппингами товаров и заказов.
 */
public class ItemOrderMappingServiceImpl implements ItemOrderMappingService {

    private final ItemOrderRepositoryImpl itemOrderRepository;

    /**
     * Конструктор с автозаполнением зависимостей.
     *
     * @param itemOrderRepository репозиторий для сохранения и получения связей товаров и заказов
     */
    @Autowired
    public ItemOrderMappingServiceImpl(ItemOrderRepositoryImpl itemOrderRepository) {
        this.itemOrderRepository = itemOrderRepository;
    }

    /**
     * Создает маппинг между товаром и заказом с указанным количеством.
     *
     * @param item     товар
     * @param order    заказ
     * @param quantity количество товара в заказе
     */
    @Override
    public void create(Item item, Order order, Integer quantity) {
        ItemOrderMapping itemOrderMapping = new ItemOrderMapping();
        itemOrderMapping.setItem(item);
        itemOrderMapping.setOrder(order);
        itemOrderMapping.setQuantity(quantity);
        itemOrderRepository.save(itemOrderMapping);
    }

    /**
     * Находит маппинг товара и заказа по идентификатору.
     *
     * @param id идентификатор маппинга
     * @return объект {@link ItemOrderMapping}, если найден; null, если маппинг не найден
     */
    @Override
    public ItemOrderMapping findById(Long id) {
        return itemOrderRepository.findById(String.valueOf(id));
    }

    /**
     * Удаляет маппинг товара и заказа по идентификатору.
     *
     * @param id идентификатор маппинга
     */
    @Override
    public void deleteById(Long id) {
        itemOrderRepository.deleteById(String.valueOf(id));
    }

    /**
     * Обновляет существующий маппинг товара и заказа с новыми данными.
     *
     * @param id       идентификатор маппинга
     * @param item     новый товар
     * @param order    новый заказ
     * @param quantity новое количество товара в заказе
     */
    @Override
    public void update(Long id, Item item, Order order, Integer quantity) {
        ItemOrderMapping itemOrderMapping = findById(id);
        itemOrderMapping.setItem(item);
        itemOrderMapping.setOrder(order);
        itemOrderMapping.setQuantity(quantity);
        itemOrderRepository.save(itemOrderMapping);
    }
}
