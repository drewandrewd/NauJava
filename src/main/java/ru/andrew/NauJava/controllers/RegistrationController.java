package ru.andrew.NauJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.andrew.NauJava.models.User;
import ru.andrew.NauJava.services.UserService;

import java.util.List;

/**
 * Контроллер для управления регистрацией и аутентификацией пользователей.
 */
@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Показать страницу регистрации.
     *
     * @param model объект для передачи данных в представление
     * @return имя представления для страницы регистрации
     */
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    /**
     * Обработать запрос на регистрацию пользователя.
     *
     * @param username имя пользователя
     * @param password пароль пользователя
     * @param model объект для передачи данных в представление
     * @return перенаправление на страницу входа или возврат на страницу регистрации с сообщением об ошибке
     */
    @PostMapping("/registration")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {
        try {
            userService.createUser(username, password, List.of("USER"));
            model.addAttribute("message", "Пользователь успешно зарегистрирован!");
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("message", "Ошибка при регистрации пользователя: " + e.getMessage());
            e.printStackTrace();
            return "registration";
        }
    }

    /**
     * Показать страницу входа.
     *
     * @param error сообщение об ошибке (если есть)
     * @param model объект для передачи данных в представление
     * @return имя представления для страницы входа
     */
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Неверный логин или пароль");
        }
        return "login";
    }

    /**
     * Показать главную страницу после успешного входа.
     *
     * @param model объект для передачи данных в представление
     * @return имя представления для главной страницы
     */
    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("message", "Вы вошли в систему");
        return "home";
    }
}
