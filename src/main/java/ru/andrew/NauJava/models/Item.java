package ru.andrew.NauJava.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor()
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name="items")
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Integer weight;

    @Column
    private Double price;

    public Item(String name, String description, Integer weight, Double price) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
    }

}
