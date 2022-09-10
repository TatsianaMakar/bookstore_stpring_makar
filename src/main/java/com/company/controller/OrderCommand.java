//package com.company.controller;
//
//import com.company.dao.entity.Order;
//import com.company.service.impl.OrderServiceImpl;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component("order")
//public class OrderCommand implements Command {
//    private final OrderServiceImpl orderServiceImpl;
//
//    @Autowired
//    public OrderCommand(OrderServiceImpl orderServiceImpl) {
//        this.orderServiceImpl = orderServiceImpl;
//    }
//
//    @Override
//    public String execute(HttpServletRequest req) {
//        Long idOrder = Long.parseLong(req.getParameter("id"));
//        Order order = orderServiceImpl.findById(idOrder);
//        req.setAttribute("order", order);
//        return "jsp/order.jsp";
//    }
//}
