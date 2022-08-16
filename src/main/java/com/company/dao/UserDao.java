package com.company.dao;

import com.company.entity.User;

import java.util.List;

public interface UserDao {

    User create(User user);

    List<User> getAll();

    User getUserByEmail(String email);

    User getUserById(Long id);

    User update(User user);

    boolean delete(Long id);
}
