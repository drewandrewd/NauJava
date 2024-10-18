package ru.andrew.NauJava.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.andrew.NauJava.models.Item;
import ru.andrew.NauJava.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UserRepository implements CrudRepository<User, String> {

    private final Map<String, User> users;

    @Autowired
    public UserRepository(Map<String, User> users) {
        this.users = users;
    }

    @PostConstruct
    public void init() {
        users.put("admin", new User(1L, "admin"));
    }

    @Override
    public String create(User user) {
        users.put(user.getName(), user);
        return user.getName();
    }

    @Override
    public User read(String name) {
        return users.get(name);
    }

    @Override
    public void update(User user, String name) {
        users.replace(name, user);
    }

    @Override
    public void delete(String name) {
        users.remove(name);
    }

}
