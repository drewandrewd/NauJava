package ru.andrew.NauJava.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс, представляющий исключение с сообщением.
 */
@Data
@AllArgsConstructor
public class Exception {
    private String message;

    /**
     * Создает новое исключение с сообщением из Throwable.
     *
     * @param e объект Throwable, из которого будет получено сообщение
     * @return новое исключение с сообщением
     */
    public static Exception create(Throwable e) {
        return new Exception(e.getMessage());
    }

    /**
     * Создает новое исключение с заданным сообщением.
     *
     * @param message сообщение исключения
     * @return новое исключение с заданным сообщением
     */
    public static Exception create(String message) {
        return new Exception(message);
    }
}
