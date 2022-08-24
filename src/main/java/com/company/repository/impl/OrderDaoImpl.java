package com.company.repository.impl;

import com.company.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long create(Long entity) {
        return null;
    }

    @Override
    public Long findById(OrderDao id) {
        return null;
    }

    @Override
    public OrderDao countAll() {
        return null;
    }

    @Override
    public List<Long> findAll() {
        return null;
    }

    @Override
    public Long update(Long entity) {
        return null;
    }

    @Override
    public boolean delete(OrderDao id) {
        return false;
    }
}
