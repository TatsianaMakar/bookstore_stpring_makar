//package com.company.dao.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.List;
//
//@Data
//@Entity(name = "orders")
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @OneToMany(mappedBy = "order", cascade = CascadeType.REFRESH)
//    private List<OrderItem> orderItems;
//
//    @ManyToMany(cascade = CascadeType.REFRESH)
//    @JoinTable(name = "order_item",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "book_id"))
//    private List<Book> books;
//
//    @ManyToOne(cascade = {CascadeType.PERSIST,
//            CascadeType.MERGE,
//            CascadeType.REFRESH})
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @Column(name = "status")
//    @Enumerated(EnumType.STRING)
//    private Status status;
//
//    @Column(name = "total_cost")
//    private BigDecimal totalCost;
//
//    public enum Status {
//        PENDING, CONFIRMED, DELIVERED, CANCELED
//    }
//
//}
