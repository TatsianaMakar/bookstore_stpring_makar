package com.company.service.impl;

import com.company.dao.entity.User;
import com.company.repository.impl.UserRepositoryImpl;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepositoryImpl userRepository;

    @Autowired
    public UserServiceImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new RuntimeException("Can't find user with id=" + id);
        }
        return user;
    }

    @Override
    public void delete(Long id) {
        boolean success = userRepository.delete(id);
        if (!success) {
            throw new RuntimeException("Can't find user with id=" + id);
        }
    }

    @Override
    public User create(User entity) {
        User user = userRepository.create(entity);
        validateEmail(entity);
        if (entity.getUserPassword() == null) {
            throw new RuntimeException("You should enter the password");
        }
        return user;
    }

    @Override
    public User update(User entity) {
        User user = userRepository.update(entity);
        validateEmail(entity);
        if (user == null) {
            throw new RuntimeException("Can't find user");
        }
        return user;
    }

    public void validateEmail(User entity) {
        List<User> users = findAll();
        for (int j = 0; j < users.size() - 1; j++) {
            if (users.get(j) != null && Objects.equals(users.get(j).getUserEmail(), entity.getUserEmail())) {
                throw new RuntimeException("User with email: " + entity.getUserEmail() + " already exist");
            }
        }
    }
}
