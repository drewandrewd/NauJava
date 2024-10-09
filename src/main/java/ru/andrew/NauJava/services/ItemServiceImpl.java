package ru.andrew.NauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.repositories.ItemRepository;

import java.util.List;
import java.util.Random;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Long createItem(String name, String description, Integer weight, Double price) {
        Item item = new Item();
        item.setId(new Random().nextLong() >>> 1);
        item.setName(name);
        item.setDescription(description);
        item.setWeight(weight);
        item.setPrice(price);
        itemRepository.create(item);
        return item.getId();
    }

    @Override
    public Item findByName(String name) {
        return itemRepository.read(name);
    }

    @Override
    public void deleteByName(String name) {
        itemRepository.delete(name);
    }

    @Override
    public void updateItem(String name, String description, Integer weight, Double price) {
        Item item = itemRepository.read(name);
        item.setDescription(description);
        item.setWeight(weight);
        item.setPrice(price);
        itemRepository.update(item, item.getName());
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }
}
