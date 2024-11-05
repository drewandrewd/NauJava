package ru.andrew.NauJava.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.andrew.NauJava.config.SpringSecurityConfig;
import ru.andrew.NauJava.models.Role;
import ru.andrew.NauJava.models.User;
import ru.andrew.NauJava.repositories.RoleRepository;
import ru.andrew.NauJava.repositories.UserRepository;

import java.util.List;
import java.util.Set;

/**
 * Сервис для управления пользователями.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final SpringSecurityConfig springSecurityConfig;

    /**
     * Конструктор для внедрения зависимостей.
     *
     * @param userRepository      репозиторий для работы с пользователями
     * @param roleRepository      репозиторий для работы с ролями
     * @param springSecurityConfig конфигурация для работы с Spring Security
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, SpringSecurityConfig springSecurityConfig) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.springSecurityConfig = springSecurityConfig;
    }

    /**
     * Метод инициализации, создающий администратора при запуске приложения.
     * Устанавливает имя "admin" и пароль "admin", который шифруется с помощью PasswordEncoder.
     */
    @PostConstruct
    public void init() {
        User user = new User();
        user.setName("admin");
        user.setPassword(springSecurityConfig.getPasswordEncoder().encode("admin"));
        user.setRoles(Set.of(Role.createWithName("ADMIN")));
        userRepository.save(user);
    }

    /**
     * Создает нового пользователя с указанными именем, паролем и ролями.
     *
     * @param userName  имя пользователя
     * @param password  пароль пользователя (будет зашифрован перед сохранением)
     * @param roleNames список названий ролей, которые будут назначены пользователю
     */
    @Override
    public void createUser(String userName, String password, List<String> roleNames) {
        User user = new User();
        user.setName(userName);
        user.setPassword(springSecurityConfig.getPasswordEncoder().encode(password));
        user.setRoles(Set.of(roleRepository.findByName("USER").get()));
        userRepository.save(user);
    }

    /**
     * Находит пользователя по идентификатору.
     *
     * @param id идентификатор пользователя
     * @return пользователь, если найден; новый объект User в случае отсутствия
     */
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    /**
     * Удаляет пользователя по идентификатору.
     *
     * @param id идентификатор пользователя
     */
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
