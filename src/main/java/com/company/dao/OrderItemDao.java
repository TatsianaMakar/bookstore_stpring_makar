package com.company.dao;

import com.company.dao.entity.OrderItem;

import java.util.List;

public interface OrderItemDao extends AbstractDao<Long, OrderItem> {
    List<OrderItem> findByOrderId(Long orderId);
}
