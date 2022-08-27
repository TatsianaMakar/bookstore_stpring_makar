package com.company.controller;

import com.company.dao.entity.Order;
import com.company.service.impl.OrderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("orders")
public class OrdersCommand implements Command {
    private final OrderServiceImpl orderServiceImpl;

    @Autowired
    public OrdersCommand(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @Override
    public String execute(HttpServletRequest req) {
        List<Order> orders = orderServiceImpl.findAll();
        req.setAttribute("orders", orders);
        return "jsp/orders.jsp";
    }
}
