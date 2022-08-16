package com.company.service;

import com.company.dao.UserDao;
import com.company.entity.User;

import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll() {
       // Log.logger.debug("Method 'getAll' called");
        return userDao.getAll();
    }

    public User getById(Long id) {
       // Log.logger.debug("Method 'getById' called");
        User user = userDao.getUserById(id);
        if (user == null) {
            throw new RuntimeException("Can't find user with id=" + id);
        }
        return user;
    }

    public void delete(Long id) {
       // Log.logger.debug("Method 'delete' called");
        boolean success = userDao.delete(id);
        if (!success) {
            throw new RuntimeException("Can't find user with id=" + id);
        }
    }

    public void create(User entity) {
      //  Log.logger.debug("Method 'create' called");
        User user = userDao.create(entity);
        if (entity.getUserPassword() == null) {
            throw new RuntimeException("You should enter the password");
        }
    }

    public User update(User entity) {
       // Log.logger.debug("Method 'update' called");
        User user = userDao.update(entity);
        if (user == null) {
            throw new RuntimeException("Can't find user");
        }
        return user;
    }
}
