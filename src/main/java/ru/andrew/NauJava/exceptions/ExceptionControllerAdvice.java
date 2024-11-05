package ru.andrew.NauJava.exceptions;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Класс, отвечающий за обработку исключений в приложении.
 * Используется для централизованной обработки исключений, которые могут возникать в контроллерах.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * Обработчик для всех исключений, возвращает статус 500 (Внутренняя ошибка сервера).
     *
     * @param e Исключение, которое было выброшено.
     * @return Объект {@link ErrorResponse} с сообщением об ошибке.
     */
    @ExceptionHandler(java.lang.Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAllExceptions(Exception e) {
        return new ErrorResponse(e.getMessage());
    }

    /**
     * Обработчик для исключений {@link ResourceNotFoundException}, возвращает статус 404 (Не найдено).
     *
     * @param e Исключение, которое было выброшено.
     * @return Объект {@link ErrorResponse} с сообщением об ошибке.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleResourceNotFound(ResourceNotFoundException e) {
        return new ErrorResponse(e.getMessage());
    }
}
