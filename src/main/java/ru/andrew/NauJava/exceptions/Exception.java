package ru.andrew.NauJava.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Exception {
    private String message;

    public static Exception create(Throwable e)
    {
        return new Exception(e.getMessage());
    }
    public static Exception create(String message)
    {
        return new Exception(message);
    }
}
