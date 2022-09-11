//package com.company.dao.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.List;
//
//@Data
//@Entity(name = "books")
//public class Book {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @OneToMany(mappedBy = "book", cascade = CascadeType.REFRESH)
//    private List<OrderItem> orderItems;
//
//    @ManyToMany(cascade = {CascadeType.REFRESH,
//            CascadeType.MERGE,
//            CascadeType.REFRESH})
//    @JoinTable(name = "order_item",
//            joinColumns = @JoinColumn(name = "book_id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id"))
//    private List<Order> orders;
//
//    @Column(name = "book_name")
//    private String bookName;
//
//    @Column(name = "author")
//    private String author;
//
//    @Column(name = "year")
//    private int year;
//
//    @Column(name = "price")
//    private BigDecimal price;
//
//    @Column(name = "isbn")
//    private String isbn;
//
//    @Column(name = "cover")
//    @Enumerated(EnumType.STRING)
//    private Cover cover;
//
//    public enum Cover {SOFT, HARD, SPECIAL}
//
//}
