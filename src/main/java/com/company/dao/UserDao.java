package com.company.dao;

import com.company.dao.dto.UserDto;

public interface UserDao extends AbstractDao<Long, UserDto> {
    UserDto getUserByEmail(String email);

}
