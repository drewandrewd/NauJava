package ru.andrew.NauJava.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.andrew.NauJava.services.ItemService;

import java.util.Scanner;

@Configuration
public class ConsoleProcessor {
    @Autowired
    private CommandProcessor commandProcessor;

    private final ItemService itemService;

    public ConsoleProcessor(ItemService itemService) {
        this.itemService = itemService;
    }

    @Bean
    public CommandLineRunner commandScanner() {
        return args ->
        {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Введите команду. 'exit' для выхода.");
                System.out.println("Меню:");
                itemService.getAllItems().stream().forEach(a -> System.out.println(a.getName()));
                while (true) {
                    System.out.print("> ");
                    String input = scanner.nextLine();
                    if ("exit".equalsIgnoreCase(input.trim())) {
                        System.out.println("Выход из программы...");
                        break;
                    }
                    commandProcessor.processCommand(input);
                }
            }
        };
    }
}
