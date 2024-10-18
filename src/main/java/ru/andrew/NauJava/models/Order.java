package ru.andrew.NauJava.models;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Order {

    private Long id;

    private User user;

    private List<Item> items;

    private Double fullPrice;
}
