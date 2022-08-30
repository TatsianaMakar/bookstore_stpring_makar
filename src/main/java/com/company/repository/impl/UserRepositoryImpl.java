package com.company.repository.impl;

import com.company.dao.UserDao;
import com.company.dao.dto.UserDto;
import com.company.dao.entity.User;
import com.company.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserDao userDao;
    private final ObjectMapper mapper;

    public UserRepositoryImpl(UserDao userDao, ObjectMapper mapper) {
        this.userDao = userDao;
        this.mapper = mapper;
    }

    @Override
    public User create(User entity) {
        UserDto toSave = mapper.toDto(entity);
        UserDto savedDto = userDao.create(toSave);
        if (savedDto != null) {
            entity = mapper.toEntity(savedDto);
        }
        return entity;
    }

    @Override
    public User findById(Long id) {
        UserDto dto = userDao.findById(id);
        User entity = null;
        if (dto != null) {
            entity = mapper.toEntity(dto);
        }
        return entity;
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll().stream().map(mapper::toEntity).toList();
    }

    @Override
    public User update(User entity) {
        UserDto toSave = mapper.toDto(entity);
        UserDto savedDto = userDao.update(toSave);
        if (savedDto != null) {
            entity = mapper.toEntity(savedDto);
        }
        return entity;
    }

    @Override
    public boolean delete(Long id) {
        return userDao.delete(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }
}
