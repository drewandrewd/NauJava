package ru.andrew.NauJava.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Представляет связь между товарами и заказами.
 * Позволяет хранить количество каждого товара,
 * включенного в конкретный заказ.
 */
@Entity
@Table(name = "item_order_mapping")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemOrderMapping {

    /**
     * Уникальный идентификатор записи в связывающей таблице.
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Товар, связанный с заказом.
     */
    @ManyToOne
    private Item item;

    /**
     * Заказ, к которому относится данный товар.
     */
    @ManyToOne
    private Order order;

    /**
     * Количество данного товара в заказе.
     */
    private Integer quantity;
}
