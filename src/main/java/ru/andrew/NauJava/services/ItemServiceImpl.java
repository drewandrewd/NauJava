package ru.andrew.NauJava.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.repositories.ItemRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса {@link ItemService} для управления товарами.
 */
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    /**
     * Конструктор для внедрения зависимости.
     *
     * @param itemRepository репозиторий для работы с товарами
     */
    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /**
     * Инициализирует базу данных некоторыми товарами при запуске приложения.
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("apple", "new apple", 300, 150.0));
        itemRepository.save(new Item("banana", "new banana", 400, 200.0));
        itemRepository.save(new Item("milk", "new milk", 500, 100.0));
        itemRepository.save(new Item("beer", "new beer", 500, 400.0));
        itemRepository.save(new Item("water", "new water", 500, 40.0));
    }

    /**
     * Создает новый товар с указанными характеристиками.
     *
     * @param name        название товара
     * @param description описание товара
     * @param weight      вес товара
     * @param price       цена товара
     */
    @Override
    public void createItem(String name, String description, Integer weight, Double price) {
        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setWeight(weight);
        item.setPrice(price);
        itemRepository.save(item);
    }

    /**
     * Находит товар по идентификатору.
     *
     * @param id идентификатор товара
     * @return объект {@link Item}, если найден; новый объект Item, если товар не найден
     */
    @Override
    public Item findById(Long id) {
        return itemRepository.findById(String.valueOf(id)).orElse(new Item());
    }

    /**
     * Удаляет товар по идентификатору.
     *
     * @param id идентификатор товара
     */
    @Override
    public void deleteById(Long id) {
        itemRepository.deleteById(String.valueOf(id));
    }

    /**
     * Обновляет товар с указанными характеристиками.
     *
     * @param id          идентификатор товара
     * @param name        новое название товара
     * @param description новое описание товара
     * @param weight      новый вес товара
     * @param price       новая цена товара
     */
    @Override
    public void updateItem(Long id, String name, String description, Integer weight, Double price) {
        Item item = findById(id);
        item.setDescription(description);
        item.setWeight(weight);
        item.setPrice(price);
        itemRepository.save(item);
    }

    /**
     * Возвращает список всех товаров.
     *
     * @return список объектов {@link Item}
     */
    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::add);
        return items;
    }
}
