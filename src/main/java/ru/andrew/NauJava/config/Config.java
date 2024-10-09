package ru.andrew.NauJava.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.Order;
import ru.andrew.NauJava.models.User;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {
    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public Map<Long, Order> oderContainer() {
        return new HashMap<>();
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public Map<String, User> userContainer() {
        return new HashMap<>();
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public Map<String, Item> itemContainer() {
        return new HashMap<>();
    }
}
