package ru.andrew.NauJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.repositories.ItemRepository;
import ru.andrew.NauJava.services.ItemServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ItemServiceImplTest {

    @InjectMocks
    private ItemServiceImpl itemService;

    @Mock
    private ItemRepository itemRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateItem() {
        Item item = new Item("name", "description", 1, 100.0);
        item.setId(1L);

        when(itemRepository.save(any(Item.class))).thenAnswer(invocation -> {
            Item savedItem = invocation.getArgument(0);
            savedItem.setId(1L);
            return savedItem;
        });

        verify(itemRepository, times(1)).save(any(Item.class));
    }

    @Test
    public void testFindById() {
        Item item = new Item();
        item.setId(1L);
        when(itemRepository.findById("1")).thenReturn(Optional.of(item));

        Item result = itemService.findById(1L);

        assertEquals(1L, result.getId());
        verify(itemRepository, times(1)).findById("1");
    }

    @Test
    public void testDeleteById() {
        Long itemId = 1L;

        itemService.deleteById(itemId);

        verify(itemRepository, times(1)).deleteById("1");
    }
}
