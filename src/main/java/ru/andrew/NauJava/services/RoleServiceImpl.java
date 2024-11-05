package ru.andrew.NauJava.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.andrew.NauJava.models.Role;
import ru.andrew.NauJava.repositories.RoleRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса {@link RoleService} для управления ролями.
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    /**
     * Конструктор для внедрения зависимости.
     *
     * @param roleRepository репозиторий для работы с ролями
     */
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Создает новую роль с указанным именем.
     *
     * @param name имя роли
     */
    @Override
    public void createRole(String name) {
        Role role = new Role();
        role.setName(name);
        roleRepository.save(role);
    }

    /**
     * Инициализирует базовые роли "ADMIN" и "USER" при запуске приложения, если их еще нет в базе.
     */
    @PostConstruct
    public void init() {
        if (roleRepository.findByName("ADMIN").isEmpty()) {
            roleRepository.save(Role.createWithName("ADMIN"));
        }
        if (roleRepository.findByName("USER").isEmpty()) {
            roleRepository.save(Role.createWithName("USER"));
        }
    }

    /**
     * Удаляет роль по идентификатору.
     *
     * @param id идентификатор роли
     */
    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    /**
     * Возвращает список всех ролей.
     *
     * @return список объектов {@link Role}
     */
    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }
}
