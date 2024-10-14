package ru.andrew.NauJava.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.services.ItemService;
import ru.andrew.NauJava.services.OrderService;
import ru.andrew.NauJava.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandProcessor
{
    private final OrderService orderService;
    private final ItemService itemService;
    private final UserService userService;

    @Autowired
    public CommandProcessor(OrderService orderService, ItemService itemService, UserService userService)
    {
        this.orderService = orderService;
        this.itemService = itemService;
        this.userService = userService;
    }

    public void processCommand(String input)
    {
        String[] cmd = input.split(" ");
        switch (cmd[0])
        {
            case "create" ->
            {
                List<Item> list = new ArrayList<>();
                double fullPrice = 0;
                for (int i = 0; i < Integer.parseInt(cmd[2]); i++) {
                    Item item = itemService.findById(Long.parseLong(cmd[3 + i]));
                    list.add(item);
                    fullPrice += item.getPrice();
                }
                long id = orderService.createOrder(userService.findById(Long.parseLong(cmd[1])), list, fullPrice);
                System.out.println("Заказ успешно добавлен...");
                System.out.printf("Id: %d\n", id);
            }
            case "delete" ->
            {
                orderService.deleteById(Long.parseLong(cmd[1]));
                System.out.println("Заказ успешно удален...");
            }
            case "edit" ->
            {
                long id = Long.parseLong(cmd[1]);
                List<Item> list = new ArrayList<>();
                double fullPrice = 0;
                for (int i = 0; i < Integer.parseInt(cmd[2]); i++) {
                    Item item = itemService.findById(Long.parseLong(cmd[i + 3]));
                    list.add(item);
                    fullPrice += item.getPrice();
                }
                orderService.updateOrder(id, list, fullPrice);
                System.out.println("Заказ успешно обновлен...");
                System.out.printf("Id: %d\n", id);
            }
            case "view" ->
            {
                Order order = orderService.findById(Long.parseLong(cmd[1]));
                StringBuilder builder = new StringBuilder("Ваш заказ: ");
                builder.append(order.toString());
                System.out.println(builder);
            }
// .... здесь логика Обработки других команды
            default -> System.out.println("Введена неизвестная команда...");
        }
    }
}
