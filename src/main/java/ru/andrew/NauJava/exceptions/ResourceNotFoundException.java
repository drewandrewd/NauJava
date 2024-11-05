package ru.andrew.NauJava.exceptions;

/**
 * Исключение, которое выбрасывается, когда запрашиваемый ресурс не найден.
 * Это пользовательское исключение, унаследованное от {@link RuntimeException}.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Конструктор для создания нового экземпляра {@code ResourceNotFoundException} с заданным сообщением.
     *
     * @param message Сообщение об ошибке, которое будет выведено при возникновении исключения.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
