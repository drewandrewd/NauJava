package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.Role;

import java.util.List;

/**
 * Интерфейс для сервиса управления ролями.
 */
public interface RoleService {

    /**
     * Создает новую роль с указанным именем.
     *
     * @param name имя роли
     */
    void createRole(String name);

    /**
     * Удаляет роль по идентификатору.
     *
     * @param id идентификатор роли
     */
    void deleteById(Long id);

    /**
     * Возвращает список всех ролей.
     *
     * @return список объектов {@link Role}
     */
    List<Role> getAllRoles();
}
