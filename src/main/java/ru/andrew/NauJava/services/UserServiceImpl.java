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
        userRepository.save(user);
        return user.getName();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(String.valueOf(id)).get();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(String.valueOf(id));
    }
}
