package com.company.repository;

import com.company.repository.entity.User;

public interface UserDao extends AbstractDao<Long, User> {
    User getUserByEmail(String email);

}
