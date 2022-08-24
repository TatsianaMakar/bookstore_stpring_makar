package com.company.repository.entity;

import lombok.*;

import java.math.BigDecimal;

@Data
public class Book {
    private Long id;
    private String bookName;
    private String author;
    private int year;
    private BigDecimal price;
    private String isbn;
    private Cover cover;

    public enum Cover {SOFT, HARD, SPECIAL}
}
