package ru.andrew.NauJava.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Представляет заказ в системе.
 * Заказ содержит информацию о пользователе, который его создал,
 * списке товаров и общей стоимости заказа.
 */
@Data
@ToString
@Entity
@Table(name = "orders")
public class Order {

    /**
     * Уникальный идентификатор заказа.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Пользователь, создавший заказ.
     */
    @ManyToOne
    private User user;

    /**
     * Список товаров, включенных в заказ.
     * Связь с сущностью Item, которая хранит детали каждого товара.
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<Item> items;

    /**
     * Общая стоимость заказа.
     */
    @Column
    private Double fullPrice;
}
