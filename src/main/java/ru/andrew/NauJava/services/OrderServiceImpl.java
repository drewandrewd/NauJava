package ru.andrew.NauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.models.User;
import ru.andrew.NauJava.repositories.OrderRepository;

import java.util.List;

/**
 * Реализация интерфейса {@link OrderService} для управления заказами.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    /**
     * Конструктор для внедрения зависимости.
     *
     * @param orderRepository репозиторий для работы с заказами
     */
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Создает новый заказ для пользователя с указанными товарами и общей стоимостью.
     *
     * @param user      пользователь, который создает заказ
     * @param items     список товаров в заказе
     * @param fullPrice полная стоимость заказа
     */
    @Override
    public void createOrder(User user, List<Item> items, Double fullPrice) {
        Order order = new Order();
        order.setUser(user);
        order.setItems(items);
        order.setFullPrice(fullPrice);
        orderRepository.save(order);
    }

    /**
     * Находит заказ по идентификатору.
     *
     * @param id идентификатор заказа
     * @return объект {@link Order}, если найден; новый объект Order в случае отсутствия
     */
    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(new Order());
    }

    /**
     * Удаляет заказ по идентификатору.
     *
     * @param id идентификатор заказа
     */
    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    /**
     * Обновляет заказ с указанными товарами и общей стоимостью.
     *
     * @param id        идентификатор заказа
     * @param items     новый список товаров
     * @param fullPrice новая полная стоимость заказа
     */
    @Override
    public void updateOrder(Long id, List<Item> items, Double fullPrice) {
        Order order = findById(id);
        order.setItems(items);
        order.setFullPrice(fullPrice);
        orderRepository.save(order);
    }
}
