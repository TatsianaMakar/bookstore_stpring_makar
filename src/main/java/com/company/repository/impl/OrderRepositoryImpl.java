package com.company.repository.impl;

import com.company.dao.BookDao;
import com.company.dao.OrderDao;
import com.company.dao.OrderItemDao;
import com.company.dao.UserDao;
import com.company.dao.dto.BookDto;
import com.company.dao.dto.OrderDto;
import com.company.dao.dto.UserDto;
import com.company.dao.entity.Book;
import com.company.dao.entity.Order;
import com.company.dao.entity.OrderItem;
import com.company.dao.entity.User;
import com.company.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderDao orderDao;
    private final UserDao userDao;
    private final BookDao bookDao;
    private final OrderItemDao orderItemDao;
    private final ObjectMapper mapper;


    @Override
    public Order create(Order entity) {
        return null;
    }

    @Override
    public Order findById(Long id) {
        OrderDto orderDto = orderDao.findById(id);
        if (orderDto == null) {
            return null;
        }
        Order orderEntity = mapper.toEntity(orderDto);
        Long userId = orderDto.getUserId();
        UserDto userDto = userDao.findById(userId);
        User user = mapper.toEntity(userDto);
        orderEntity.setUser(user);
        orderEntity.setTotalCost(totalCost(creatingItems(orderEntity)));
        orderEntity.setItems(creatingItems(orderEntity));
        return orderEntity;
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = orderDao.findAll().stream()
                .map(dto -> {
                    Order entity = mapper.toEntity(dto);
                    Long userId = dto.getUserId();
                    UserDto userDto = userDao.findById(userId);
                    User user = mapper.toEntity(userDto);
                    entity.setUser(user);
                    entity.setTotalCost(totalCost(creatingItems(entity)));
                    entity.setItems(creatingItems(entity));
                    return entity;
                }).toList();
        return orders;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    public BigDecimal totalCost(List<OrderItem> items) {
        BigDecimal totalCost = new BigDecimal(0);
        for (int i = 0; i < items.size(); i++) {
            OrderItem ord = items.get(i);
            BigDecimal cost = ord.getPrice().multiply(BigDecimal.valueOf(ord.getQuantity()));
            totalCost = totalCost.add(cost);
        }
        return totalCost;
    }

    public List<OrderItem> creatingItems(Order entity) {
        List<OrderItem> items = orderItemDao.findByOrderId(entity.getId()).stream()
                .map(dtoItem -> {
                    OrderItem entityItem = mapper.toEntity(dtoItem);
                    entityItem.setOrder(entity);
                    Long bookId = dtoItem.getBookId();
                    BookDto bookDto = bookDao.findById(bookId);
                    Book book = mapper.toEntity(bookDto);
                    entityItem.setBook(book);
                    return entityItem;
                }).toList();
        return items;
    }
}


