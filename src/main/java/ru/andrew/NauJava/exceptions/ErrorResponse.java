package ru.andrew.NauJava.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс, представляющий ответ об ошибке.
 */
@Data
@AllArgsConstructor
public class ErrorResponse {

    /**
     * Сообщение, описывающее ошибку.
     */
    private String message;
}
