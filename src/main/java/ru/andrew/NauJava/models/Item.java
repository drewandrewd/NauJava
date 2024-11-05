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

/**
 * Представляет товар в системе.
 * Хранит информацию о названии, описании, весе и цене товара.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "items")
public class Item {

    /**
     * Уникальный идентификатор товара.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Название товара.
     */
    @Column
    private String name;

    /**
     * Описание товара.
     */
    @Column
    private String description;

    /**
     * Вес товара в граммах.
     */
    @Column
    private Integer weight;

    /**
     * Цена товара в денежной единице.
     */
    @Column
    private Double price;

    /**
     * Конструктор для создания нового товара.
     *
     * @param name        Название товара.
     * @param description Описание товара.
     * @param weight      Вес товара в граммах.
     * @param price       Цена товара в денежной единице.
     */
    public Item(String name, String description, Integer weight, Double price) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
    }
}
