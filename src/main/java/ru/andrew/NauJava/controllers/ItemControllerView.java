package ru.andrew.NauJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.repositories.ItemRepository;

/**
 * Контроллер для отображения списка предметов.
 */
@Controller
@RequestMapping("/items/view")
public class ItemControllerView {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Показать список всех предметов.
     *
     * @param model объект для передачи данных в представление
     * @return имя представления для отображения списка предметов
     */
    @GetMapping("/list")
    public String itemListView(Model model) {
        Iterable<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "itemList";
    }
}
