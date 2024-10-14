package ru.andrew.NauJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.models.User;
import ru.andrew.NauJava.repositories.OrderRepository;
import ru.andrew.NauJava.services.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateOrder() {
        User user = new User();
        List<Item> items = new ArrayList<>();
        Double fullPrice = 100.0;
        Order order = new Order();
        order.setId(1L);

        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> {
            Order savedOrder = invocation.getArgument(0);
            savedOrder.setId(1L);
            return savedOrder;
        });

        Long orderId = orderService.createOrder(user, items, fullPrice);

        assertEquals(1L, orderId);
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    public void testFindById() {
        Order order = new Order();
        order.setId(1L);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Order result = orderService.findById(1L);

        assertEquals(1L, result.getId());
        verify(orderRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteById() {
        Long orderId = 1L;

        orderService.deleteById(orderId);

        verify(orderRepository, times(1)).deleteById(1L);
    }
}
