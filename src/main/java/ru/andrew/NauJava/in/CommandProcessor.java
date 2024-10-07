package ru.andrew.NauJava.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.services.OrderService;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandProcessor
{
    private final OrderService orderService;

    @Autowired
    public CommandProcessor(OrderService orderService)
    {
        this.orderService = orderService;
    }

    public void processCommand(String input)
    {
        String[] cmd = input.split(" ");
        switch (cmd[0])
        {
            case "create" ->
            {
                List<String> list = new ArrayList<>();
                int j = 3;
                for (int i = 0; i < Integer.parseInt(cmd[2]); i++) {
                    list.add(cmd[j + i]);
                }
                long id = orderService.createUser(cmd[1], list);
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
                List<String> list = new ArrayList<>();
                int j = 3;
                for (int i = 0; i < Integer.parseInt(cmd[2]); i++) {
                    list.add(cmd[j + i]);
                }
                orderService.updateOrder(id, list);
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
