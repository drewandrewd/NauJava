package ru.andrew.NauJava.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.andrew.NauJava.models.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ItemRepository implements CrudRepository<Item, String> {

    private final Map<String, Item> map;

    @Autowired
    public ItemRepository(Map<String, Item> map) {
        this.map = map;
    }

    @PostConstruct
    public void init() {
        map.put("apple", new Item(1L, "apple", "new apple", 300, 150.0));
        map.put("banana", new Item(2L, "banana", "new banana", 400, 200.0));
        map.put("milk", new Item(3L, "milk", "new milk", 500, 100.0));
        map.put("beer", new Item(4L, "beer", "new beer", 500, 400.0));
        map.put("water", new Item(5L, "water", "new water", 500, 40.0));
    }

    @Override
    public String create(Item item) {
        map.put(item.getName(), item);
        return item.getName();
    }

    @Override
    public Item read(String name) {
        return map.get(name);
    }

    @Override
    public void update(Item entity, String name) {
        map.replace(name, entity);
    }

    @Override
    public void delete(String name) {
        map.remove(name);
    }

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        for (Item item : map.values()) {
            items.add(item);
        }
        return items;
    }
}
