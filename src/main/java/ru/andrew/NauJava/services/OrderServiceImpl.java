package ru.andrew.NauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.repositories.OrderRepository;

import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Long createUser(String userName, List<String> items) {
        Order order = new Order();
        order.setId(new Random().nextLong());
        order.setUserName(userName);
        order.setItems(items);
        orderRepository.create(order);
        return order.getId();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.read(id);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.delete(id);
    }

    @Override
    public void updateOrder(Long id, List<String> items) {
        Order order = orderRepository.read(id);
        order.setItems(items);
        orderRepository.update(order, id);
    }
}
