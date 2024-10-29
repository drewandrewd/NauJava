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

@Controller
public class RegistrationController {


    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

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

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Неверный логин или пароль");
        }
        return "login";
    }


    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("message", "Вы вошли в систему");
        return "home";
    }
}

