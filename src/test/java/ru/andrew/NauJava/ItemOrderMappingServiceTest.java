package ru.andrew.NauJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.ItemOrderMapping;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.repositories.ItemOrderRepositoryImpl;
import ru.andrew.NauJava.services.ItemOrderMappingServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ItemOrderMappingServiceTest {

    @Mock
    private ItemOrderRepositoryImpl itemOrderRepository;

    @InjectMocks
    private ItemOrderMappingServiceImpl itemOrderMappingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        Item item = new Item();
        Order order = new Order();
        Integer quantity = 10;
        itemOrderMappingService.create(item, order, quantity);
        verify(itemOrderRepository, times(1)).save(any(ItemOrderMapping.class));
    }

    @Test
    void testFindById() {
        Long id = 1L;
        ItemOrderMapping itemOrderMapping = new ItemOrderMapping();
        itemOrderMapping.setId(id);
        when(itemOrderRepository.findById(String.valueOf(id))).thenReturn(itemOrderMapping);
        ItemOrderMapping result = itemOrderMappingService.findById(id);
        verify(itemOrderRepository, times(1)).findById(String.valueOf(id));
        assert result.equals(itemOrderMapping);
    }

    @Test
    void testDeleteById() {
        Long id = 1L;
        itemOrderMappingService.deleteById(id);
        verify(itemOrderRepository, times(1)).deleteById(String.valueOf(id));
    }

    @Test
    void testUpdate() {
        Long id = 1L;
        Item item = new Item();
        Order order = new Order();
        Integer quantity = 10;
        ItemOrderMapping itemOrderMapping = new ItemOrderMapping();
        itemOrderMapping.setId(id);
        when(itemOrderRepository.findById(String.valueOf(id))).thenReturn(itemOrderMapping);
        itemOrderMappingService.update(id, item, order, quantity);
        verify(itemOrderRepository, times(1)).findById(String.valueOf(id));
        verify(itemOrderRepository, times(1)).save(itemOrderMapping);
    }
}
