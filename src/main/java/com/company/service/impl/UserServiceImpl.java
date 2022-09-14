package com.company.service.impl;

import com.company.dao.entity.User;
import com.company.repository.UserRepository;
import com.company.service.UserService;
import com.company.service.exception.ApplicationNotFoundException;
import com.company.service.exception.ApplicationValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final EncryptionServiceImpl encryptionService;

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new ApplicationNotFoundException("Can't find user with id=" + id);
        }
        return user;
    }

    @Override
    public User create(User user) {
        String originalPassword = user.getUserPassword();
        String hashedPassword = encryptionService.digest(originalPassword);
        user.setUserPassword(hashedPassword);
        User newUser = userRepository.create(user);
        validateEmail(user);
        if (user.getUserPassword() == null) {
            throw new ApplicationValidationException("You should enter the password");
        }
        return newUser;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.delete(id)) {
            throw new ApplicationNotFoundException("No user with id: " + id);
        } else {
            userRepository.delete(id);
        }
    }

    public void validateEmail(User entity) {
        List<User> users = findAll();
        for (int j = 0; j < users.size() - 1; j++) {
            if (users.get(j) != null && Objects.equals(users.get(j).getUserEmail(), entity.getUserEmail())) {
                throw new ApplicationValidationException("User with email: " + entity.getUserEmail() + " already exist");
            }
        }
    }

    @Override
    public User login(String login, String password) {
        String hashedPassword = encryptionService.digest(password);
        return userRepository.findAll().stream()
                .filter(u -> u.getUserEmail().equals(login) && u.getUserPassword().equals(hashedPassword))
                .findFirst()
                .orElseThrow(() -> new ApplicationNotFoundException("We have not user with this login"));
    }
}

