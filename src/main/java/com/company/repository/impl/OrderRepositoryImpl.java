//package com.company.repository.impl;
//
//import com.company.dao.entity.Order;
//import com.company.dao.entity.OrderItem;
//import com.company.repository.OrderRepository;
////import jakarta.persistence.EntityManager;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.math.BigDecimal;
//import java.util.List;
//
//@Repository
//@Transactional
//public class OrderRepositoryImpl implements OrderRepository {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public Order create(Order entity) {
//        return null;
//    }
//
//    @Override
//    public Order findById(Long id) {
//        Order order = entityManager.find(Order.class, id);
//        entityManager.getTransaction().begin();
//        order.setTotalCost(totalCost(order.getOrderItems()));
//        entityManager.getTransaction().commit();
//        return order;
//    }
//
//    @Override
//    public Long countAll() {
//        return null;
//    }
//
//    @Override
//    public List<Order> findAll() {
//        entityManager.getTransaction().begin();
//        List<Order> orders = entityManager.createQuery("from orders", Order.class).getResultList();
//        for (int j = 0; j < orders.size(); j++) {
//            Order order = orders.get(j);
//            order.setTotalCost(totalCost(order.getOrderItems()));
//        }
//        entityManager.getTransaction().commit();
//        return orders;
//    }
//
//    @Override
//    public Order update(Order entity) {
//        return null;
//    }
//
//    @Override
//    public boolean delete(Long id) {
//        return false;
//    }
//
//    public BigDecimal totalCost(List<OrderItem> items) {
//        BigDecimal totalCost = new BigDecimal(0);
//        for (int i = 0; i < items.size(); i++) {
//            OrderItem ord = items.get(i);
//            BigDecimal cost = ord.getPrice().multiply(BigDecimal.valueOf(ord.getQuantity()));
//            totalCost = totalCost.add(cost);
//        }
//        return totalCost;
//    }
//}


