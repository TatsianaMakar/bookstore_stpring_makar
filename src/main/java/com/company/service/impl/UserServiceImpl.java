package com.company.service.impl;

import com.company.dao.UserDao;
import com.company.entity.User;
import com.company.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User getById(Long id) {
        User user = userDao.getUserById(id);
        if (user == null) {
            throw new RuntimeException("Can't find user with id=" + id);
        }
        return user;
    }

    public void delete(Long id) {
        boolean success = userDao.delete(id);
        if (!success) {
            throw new RuntimeException("Can't find user with id=" + id);
        }
    }

    public void create(User entity) {
        User user = userDao.create(entity);
        if (entity.getUserPassword() == null) {
            throw new RuntimeException("You should enter the password");
        }
    }

    public User update(User entity) {
        User user = userDao.update(entity);
        if (user == null) {
            throw new RuntimeException("Can't find user");
        }
        return user;
    }
}
