package ru.andrew.NauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.models.User;
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
    public void createOrder(User user, List<Item> items, Double fullPrice) {
        Order order = new Order();
        order.setUser(user);
        order.setItems(items);
        order.setFullPrice(fullPrice);
        orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(new Order());
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void updateOrder(Long id, List<Item> items, Double fullPrice) {
        Order order = findById(id);
        order.setItems(items);
        order.setFullPrice(fullPrice);
        orderRepository.save(order);
    }
}
