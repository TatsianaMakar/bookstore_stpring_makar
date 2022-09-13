package com.company.repository;


import com.company.dao.entity.User;

public interface UserRepository extends AbstractRepository<Long, User> {
    User getUserByEmail(String email);
    User login(String login, String password);
}
