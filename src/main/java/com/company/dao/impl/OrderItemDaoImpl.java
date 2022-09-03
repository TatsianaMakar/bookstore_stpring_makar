package com.company.dao.impl;

import com.company.dao.OrderItemDao;
import com.company.dao.dto.OrderItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderItemDaoImpl implements OrderItemDao {
    private final JdbcTemplate jdbcTemplate;
    // private final BookDao bookDao;
    private static final String GET_BY_ORDER_ID = "SELECT * FROM order_item WHERE order_id=? AND deleted=FALSE";

    @Override
    public OrderItemDto create(OrderItemDto entity) {
        return null;
    }

    @Override
    public OrderItemDto findById(Long id) {
        return null;
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<OrderItemDto> findAll() {
        return null;
    }

    @Override
    public OrderItemDto update(OrderItemDto entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<OrderItemDto> findByOrderId(Long orderId) {
        return jdbcTemplate.query(GET_BY_ORDER_ID, this::mapRow, orderId);
    }

    public OrderItemDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(rs.getLong("id"));
        orderItemDto.setQuantity(rs.getInt("quantity"));
        orderItemDto.setPrice(rs.getBigDecimal("price"));
        orderItemDto.setOrderId(rs.getLong("order_id"));
        orderItemDto.setBookId(rs.getLong("book_id"));
        return orderItemDto;
    }
}
