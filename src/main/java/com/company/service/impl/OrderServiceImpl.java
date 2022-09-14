package com.company.service.impl;

import com.company.dao.entity.Order;
import com.company.repository.OrderRepository;
import com.company.service.OrderService;
import com.company.service.exception.ApplicationNotFoundException;
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
            throw new ApplicationNotFoundException("Can't find order with id=" + id);
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
        if (!orderRepository.delete(id)) {
            throw new ApplicationNotFoundException("No order with id: " + id);
        } else {
            orderRepository.delete(id);
        }
    }

}