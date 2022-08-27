package com.company.repository.impl;

import com.company.repository.OrderDao;
import com.company.repository.OrderItemDao;
import com.company.repository.UserDao;
import com.company.repository.entity.Order;
import com.company.repository.entity.OrderItem;
import com.company.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    private final JdbcTemplate jdbcTemplate;
    private final UserDao userDao;
    private final OrderItemDao orderItemDao;

    private static final String GET_BY_ID = """
            SELECT o.id, o.status, o.total_cost, o.user_id
            FROM orders o
            WHERE o.id=?
            """;

    @Autowired
    public OrderDaoImpl(JdbcTemplate jdbcTemplate, UserDao userDao, OrderItemDao orderItemDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
        this.orderItemDao = orderItemDao;
    }

    @Override
    public Order create(Order entity) {
        return null;
    }

    @Override
    public Order findById(Long id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, this::mapRow, id);
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getLong("id"));
        order.setStatus(Order.Status.valueOf(rs.getString("status_name")));
        order.setTotalCost(rs.getBigDecimal("totalPrice"));
        Long userId = rs.getLong("user_id");
        User user = userDao.findById(userId);
        List<OrderItem> items = orderItemDao.findByOrderId(order.getId());
        order.setItems(items);
        return order;
    }
}
