package ru.andrew.NauJava.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Представляет роль в системе.
 * Роли используются для управления доступом пользователей к различным ресурсам.
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
@Data
public class Role {

    /**
     * Уникальный идентификатор роли.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Название роли. Должно быть уникальным и не может быть пустым.
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Создает новый экземпляр роли с заданным именем.
     *
     * @param name название роли
     * @return новый объект Role с установленным именем
     */
    public static Role createWithName(String name) {
        Role role = new Role();
        role.setName(name);
        return role;
    }
}
