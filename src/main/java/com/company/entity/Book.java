package com.company.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Book {
    private Long id;
    private java.lang.String bookName;
    private java.lang.String author;
    private int year;
    private BigDecimal price;
    private java.lang.String isbn;
    private Cover cover;

    public enum Cover {SOFT, HARD, SPECIAL}

    public Book() {
    }

    ;

    public Book(Long id, String bookName, String author, int year, BigDecimal price, String isbn, Cover cover) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
        this.cover = cover;
    }

    public Book(String bookName, String author, int year, BigDecimal price, String isbn, Cover cover) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
        this.cover = cover;
    }


    public Long getId() {
        return id;
    }

    public java.lang.String getBookName() {
        return bookName;
    }

    public java.lang.String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public java.lang.String getIsbn() {
        return isbn;
    }

    public Cover getCover() {
        return cover;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String setName(java.lang.String name) {
        this.bookName = name;
        return name;
    }

    public void setAuthor(java.lang.String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setIsbn(java.lang.String isbn) {
        this.isbn = isbn;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && id.equals(book.id) && bookName.equals(book.bookName) && author.equals(book.author) && price.equals(book.price) && isbn.equals(book.isbn) && cover.equals(book.cover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, author, year, price, isbn, cover);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", isbn='" + isbn + '\'' +
                ", cover=" + cover +
                '}';
    }
}
