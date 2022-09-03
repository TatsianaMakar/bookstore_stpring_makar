package com.company.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

}
