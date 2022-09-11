package com.company.service.impl;

import com.company.dao.entity.User;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public User create(User user) {
        User newUser = userRepository.create(user);
        validateEmail(user);
        if (user.getUserPassword() == null) {
            throw new RuntimeException("You should enter the password");
        }
        return newUser;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
        if (!userRepository.delete(id)) {
            throw new RuntimeException("No user with id: " + id);
        }
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

