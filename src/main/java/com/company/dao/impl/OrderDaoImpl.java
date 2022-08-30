package com.company.dao.impl;

import com.company.dao.OrderDao;
import com.company.dao.OrderItemDao;
import com.company.dao.UserDao;
import com.company.dao.dto.OrderDto;
import lombok.RequiredArgsConstructor;
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
    public OrderDto create(OrderDto entity) {
        return null;
    }

    @Override
    public OrderDto findById(Long id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, this::mapRow, id);
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<OrderDto> findAll() {
        return jdbcTemplate.query(GET_ALL, this::mapRow);
    }

    @Override
    public OrderDto update(OrderDto entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    public OrderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(rs.getLong("id"));
        orderDto.setUserId(rs.getLong("user_id"));
        orderDto.setStatus(OrderDto.Status.valueOf(rs.getString("status_name")));
        orderDto.setTotalCost(rs.getBigDecimal("total_cost"));
        return orderDto;
    }
}
