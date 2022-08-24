package com.company.service.impl;

import com.company.repository.OrderDao;
import com.company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Long findById(OrderDao id) {
        return null;
    }

    @Override
    public void delete(OrderDao id) {

    }

    @Override
    public Long create(Long entity) {
        return null;
    }

    @Override
    public Long update(Long entity) {
        return null;
    }
}
