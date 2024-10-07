package ru.andrew.NauJava.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.andrew.NauJava.models.Order;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {
    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public Map<Long, Order> userContainer()
    {
        return new HashMap<>();
    }
}
