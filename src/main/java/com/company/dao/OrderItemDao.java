package com.company.dao;

import com.company.dao.dto.OrderItemDto;
import com.company.dao.entity.OrderItem;

import java.util.List;

public interface OrderItemDao extends AbstractDao<Long, OrderItemDto> {
    List<OrderItemDto> findByOrderId(Long orderId);
}
