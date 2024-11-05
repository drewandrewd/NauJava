package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.User;

import java.util.List;

/**
 * Интерфейс сервиса для управления пользователями.
 */
public interface UserService {

    /**
     * Создает нового пользователя с указанными именем, паролем и ролями.
     *
     * @param userName имя пользователя
     * @param password пароль пользователя (будет зашифрован перед сохранением)
     * @param roles    список ролей, которые будут назначены пользователю
     */
    void createUser(String userName, String password, List<String> roles);

    /**
     * Находит пользователя по идентификатору.
     *
     * @param id идентификатор пользователя
     * @return пользователь, если найден; null, если пользователь не найден
     */
    User findById(Long id);

    /**
     * Удаляет пользователя по идентификатору.
     *
     * @param id идентификатор пользователя
     */
    void deleteById(Long id);
}
