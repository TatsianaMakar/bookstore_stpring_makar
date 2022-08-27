package com.company.repository.impl;

import com.company.repository.OrderDao;
import com.company.repository.OrderItemDao;
import com.company.repository.UserDao;
import com.company.repository.entity.Order;
import com.company.repository.entity.OrderItem;
import com.company.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDaoImpl implements OrderDao {
    private final JdbcTemplate jdbcTemplate;
    private final UserDao userDao;
    private final OrderItemDao orderItemDao;

    private static final String GET_BY_ID = """
            SELECT o.id, 
            o.user_id, 
            o.total_cost,
            status.status_name FROM orders o JOIN status
            ON o.status_id=status.id
            WHERE o.id=? AND deleted=FALSE
            """;
    public static final String GET_ALL = """
            SELECT o.id, o.user_id, o.total_cost, 
            status.status_name FROM orders o JOIN status
            ON o.status_id=status.id AND deleted=FALSE
            """;

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
        return jdbcTemplate.query(GET_ALL, this::mapRow);
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
        order.setTotalCost(rs.getBigDecimal("total_cost"));
        Long userId = rs.getLong("user_id");
        User user = userDao.findById(userId);
        order.setUser(user);
        List<OrderItem> items = orderItemDao.findByOrderId(order.getId());
        order.setItems(items);
        return order;
    }
}
