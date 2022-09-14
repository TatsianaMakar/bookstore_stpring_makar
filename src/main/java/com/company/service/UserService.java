package com.company.service;

import com.company.dao.entity.User;

public interface UserService extends AbstractService<Long, User> {
    User login(String login, String password);
}
