package com.company.service;

import com.company.dao.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    private static EntityManagerFactory factory = null;

    public static void main(String[] args) {

        try {
            init();
            EntityManager entityManager = factory.createEntityManager();
            Book book = entityManager.find(Book.class, 3L);
            System.out.println(book);

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
