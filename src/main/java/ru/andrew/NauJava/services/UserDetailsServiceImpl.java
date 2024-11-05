package ru.andrew.NauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import ru.andrew.NauJava.repositories.UserRepository;

/**
 * Реализация {@link UserDetailsService} для загрузки пользователя по имени.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Конструктор для внедрения зависимостей.
     *
     * @param userRepository репозиторий для работы с пользователями
     */
    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Загружает пользователя по имени пользователя.
     *
     * @param username имя пользователя
     * @return объект {@link UserDetails}, представляющий пользователя
     * @throws UsernameNotFoundException если пользователь не найден
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByName(username)
                .map(user -> new User(
                        user.getName(),
                        user.getPassword(),
                        user.getAuthorities())) // Предполагается, что у вас есть метод getAuthorities()
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с именем '" + username + "' не найден"));
    }
}
