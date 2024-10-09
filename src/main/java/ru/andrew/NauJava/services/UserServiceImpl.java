package ru.andrew.NauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.andrew.NauJava.models.User;
import ru.andrew.NauJava.repositories.UserRepository;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(String userName) {
        User user = new User();
        user.setName(userName);
        user.setId(new Random().nextLong() >>> 1);
        userRepository.create(user);
        return user.getName();
    }

    @Override
    public User findByName(String name) {
        return userRepository.read(name);
    }

    @Override
    public void deleteByName(String name) {
        userRepository.delete(name);
    }
}
