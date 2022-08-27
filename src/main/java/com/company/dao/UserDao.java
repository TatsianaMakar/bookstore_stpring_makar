package com.company.dao;

import com.company.dao.entity.User;

public interface UserDao extends AbstractDao<Long, User> {
    User getUserByEmail(String email);

}
