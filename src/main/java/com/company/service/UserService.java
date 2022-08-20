package com.company.service;

import com.company.entity.User;

public interface UserService {
    public User findById(Long id);

    public void delete(Long id);

    public void create(User entity);

    public User update(User entity);
}
