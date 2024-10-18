package ru.andrew.NauJava.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Item {

    private Long id;

    private String name;

    private String description;

    private Integer weight;

    private Double price;
}
