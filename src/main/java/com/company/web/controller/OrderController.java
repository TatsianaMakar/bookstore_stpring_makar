package com.company.web.controller;

import com.company.dao.entity.Order;
import com.company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable Long id, Model model) {
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return "order";
    }

    @GetMapping("/getAll")
    public String getOrders(Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/create")
    public String createOrderForm() {
        return "createOrderForm";
    }

    @PostMapping("/create")
    public String createOrder(@ModelAttribute Order order) {
        orderService.create(order);
        return "redirect:/order/" + order.getId();
    }

    @GetMapping("/edit/{id}")
    public String updateOrderForm(@PathVariable Long id, Model model) {
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return "updateOrderForm";
    }

    @PostMapping("/edit/{id}")
    public String updateOrder(@ModelAttribute Order order) {
        orderService.create(order);
        return "redirect:/order/" + order.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteOrderForm(@PathVariable Long id, Model model) {
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return "deleteOrderForm";
    }
    @PostMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        return "delete";
    }
}

