package ru.andrew.NauJava.models;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private Long id;

    private String userName;

    private List<String> items;
}
