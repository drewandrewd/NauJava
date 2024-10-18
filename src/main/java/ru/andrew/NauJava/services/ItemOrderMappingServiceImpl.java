package ru.andrew.NauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.ItemOrderMapping;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.repositories.ItemOrderRepositoryImpl;

public class ItemOrderMappingServiceImpl implements ItemOrderMappingService {

    private final ItemOrderRepositoryImpl itemOrderRepository;

    @Autowired
    public ItemOrderMappingServiceImpl(ItemOrderRepositoryImpl itemOrderRepository) {
        this.itemOrderRepository = itemOrderRepository;
    }

    @Override
    public void create(Item item, Order order, Integer quantity) {
        ItemOrderMapping itemOrderMapping = new ItemOrderMapping();
        itemOrderMapping.setItem(item);
        itemOrderMapping.setOrder(order);
        itemOrderMapping.setQuantity(quantity);
        itemOrderRepository.save(itemOrderMapping);
    }

    @Override
    public ItemOrderMapping findById(Long id) {
        return itemOrderRepository.findById(String.valueOf(id));
    }

    @Override
    public void deleteById(Long id) {
        itemOrderRepository.deleteById(String.valueOf(id));
    }

    @Override
    public void update(Long id, Item item, Order order, Integer quantity) {
        ItemOrderMapping itemOrderMapping = findById(id);
        itemOrderMapping.setItem(item);
        itemOrderMapping.setOrder(order);
        itemOrderMapping.setQuantity(quantity);
        itemOrderRepository.save(itemOrderMapping);
    }
}
