//package com.company.service.impl;
//
//import com.company.dao.entity.Order;
//import com.company.repository.impl.OrderRepositoryImpl;
//import com.company.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OrderServiceImpl implements OrderService {
//    private final OrderRepositoryImpl orderRepository;
//
//    @Autowired
//    public OrderServiceImpl(OrderRepositoryImpl orderRepository) {
//        this.orderRepository = orderRepository;
//    }
//
//    @Override
//    public Order findById(Long id) {
//        Order order = orderRepository.findById(id);
//        return order;
//    }
//
//    @Override
//    public List<Order> findAll() {
//        return orderRepository.findAll();
//    }
//
//    @Override
//    public void delete(Long id) {
//    }
//
//    @Override
//    public Order create(Order entity) {
//        return null;
//    }
//
//    @Override
//    public Order update(Order entity) {
//        return null;
//    }
//}
