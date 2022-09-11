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
package com.company.service.impl;

import com.company.dao.entity.Order;
import com.company.repository.OrderRepository;
import com.company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findById(Long id) {
        Order order = orderRepository.findById(id);
        if (order == null) {
            throw new RuntimeException("Can't find order with id=" + id);
        }
        return order;
    }

    @Override
    public Order create(Order order) {
//        Order newOrder = orderRepository.create(order);
//        return newOrder;
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(id);
        if (!orderRepository.delete(id)) {
            throw new RuntimeException("No user with id: " + id);
        }
    }

}