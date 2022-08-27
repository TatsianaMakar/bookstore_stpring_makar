package com.company.service.impl;

import com.company.repository.impl.UserDaoImpl;
import com.company.repository.entity.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDaoImpl;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public List<User> findAll() {
        return userDaoImpl.findAll();
    }

    @Override
    public User findById(Long id) {
        User user = userDaoImpl.findById(id);
        if (user == null) {
            throw new RuntimeException("Can't find user with id=" + id);
        }
        return user;
    }

    @Override
    public void delete(Long id) {
        boolean success = userDaoImpl.delete(id);
        if (!success) {
            throw new RuntimeException("Can't find user with id=" + id);
        }
    }

    @Override
    public User create(User entity) {
        User user = userDaoImpl.create(entity);
        if (entity.getUserPassword() == null) {
            throw new RuntimeException("You should enter the password");
        }
        return user;
    }

    @Override
    public User update(User entity) {
        User user = userDaoImpl.update(entity);
        if (user == null) {
            throw new RuntimeException("Can't find user");
        }
        return user;
    }
}
