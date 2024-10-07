package ru.andrew.NauJava.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.andrew.NauJava.models.Order;

import java.util.Map;

@Component
public class OrderRepository implements CrudRepository<Order, Long> {

    private final Map<Long, Order> orders;

    @Autowired
    public OrderRepository(Map<Long, Order> orders) {
        this.orders = orders;
    }

    @Override
    public Long create(Order order) {
        orders.put(order.getId(), order);
        return order.getId();
    }

    @Override
    public Order read(Long id) {
        return orders.get(id);
    }

    @Override
    public void update(Order order, Long id) {
        orders.replace(id, order);
    }

    @Override
    public void delete(Long id) {
        orders.remove(id);
    }
}
