package ru.andrew.NauJava.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_order_mapping")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemOrderMapping {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Order order;

    private Integer quantity;
}
