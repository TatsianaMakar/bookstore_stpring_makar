package com.company.repository.impl;

import com.company.repository.BookDao;
import com.company.repository.OrderItemDao;
import com.company.repository.entity.Book;
import com.company.repository.entity.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderItemDaoImpl implements OrderItemDao {
    private final JdbcTemplate jdbcTemplate;
    private final BookDao bookDao;
    private static final String GET_BY_ORDER_ID = "SELECT * FROM order_item WHERE order_id=?";

    @Override
    public OrderItem create(OrderItem entity) {
        return null;
    }

    @Override
    public OrderItem findById(Long id) {
        return null;
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<OrderItem> findAll() {
        return null;
    }

    @Override
    public OrderItem update(OrderItem entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<OrderItem> findByOrderId(Long orderId) {
        return jdbcTemplate.query(GET_BY_ORDER_ID, this::mapRow, orderId);
    }

    public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(rs.getLong("id"));
        orderItem.setQuantity(rs.getInt("quantity"));
        orderItem.setPrice(rs.getBigDecimal("price"));
        Long bookId = rs.getLong("book_id");
        Book book = bookDao.findById(bookId);
        orderItem.setBook(book);
        return orderItem;
    }
}
