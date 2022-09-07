package com.company.service;

import com.company.dao.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.Order;

public class App {
    private static EntityManagerFactory factory = null;

    public static void main(String[] args) {

        try {
            init();
            EntityManager entityManager = factory.createEntityManager();
//            Book book = entityManager.find(Book.class, 3L);
//            System.out.println(book);
            Order order = entityManager.find(Order.class, 2L);
            System.out.println(order);

        } finally {
            tearDown();
        }
    }

    private static void init() {
        factory = Persistence.createEntityManagerFactory("psql");
    }

    private static void tearDown() {
        if (factory != null) {
            factory.close();
        }
    }
}
