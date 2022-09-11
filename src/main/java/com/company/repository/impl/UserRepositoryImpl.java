package com.company.repository.impl;

import com.company.dao.entity.User;
import com.company.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User create(User user) {
        Long id = user.getId();
        if (id == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        return user;
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public Long countAll() {
        return null;
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public boolean delete(Long id) {
        User user = findById(id);
        if (user == null) {
            return false;
        } else {
            entityManager.remove(user);
            return true;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }
}
