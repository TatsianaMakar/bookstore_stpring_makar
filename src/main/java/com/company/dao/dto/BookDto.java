package com.company.dao.dto;

import com.company.dao.entity.Book;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class BookDto {
    private Long id;
    private String bookName;
    private String author;
    private int year;
    private BigDecimal price;
    private String isbn;
    private Book.Cover cover;

    public enum Cover {SOFT, HARD, SPECIAL}
}
