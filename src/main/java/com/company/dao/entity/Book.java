package com.company.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "book_name")
    private String bookName;

    @Column (name = "author")
    private String author;

    @Column (name = "year")
    private int year;

    @Column (name = "price")
    private BigDecimal price;

    @Column (name = "isbn")
    private String isbn;

    @Column(name="cover")
    @Enumerated(EnumType.STRING)
    private Cover cover;


    public enum Cover {SOFT, HARD, SPECIAL}
}
