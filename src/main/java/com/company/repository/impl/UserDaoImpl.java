package com.company.repository.impl;

import com.company.repository.UserDao;
import com.company.repository.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger log = LogManager.getLogger(UserDaoImpl.class);
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    public static final String GET_ALL = "SELECT id, user_name, user_email, user_password FROM users";
    public static final String GET_BY_EMAIL = "SELECT id, user_name, user_email, user_password FROM users WHERE user_email=?";
    public static final String GET_BY_ID = "SELECT id, user_name, user_email, user_password FROM users WHERE id=?";
    public static final String DELETE_BY_ID = "DELETE FROM users WHERE id=?";
    public static final String UPDATE_BY_ID = "UPDATE users SET user_name=?, user_email=?, user_password=? WHERE id=?";
    public static final String UPDATE_BY_ID_NAMED = "UPDATE users SET user_name=:user_name, user_email=:user_email, user_password=:user_password WHERE id=:id";
    public static final String ADD_NEW_USER = "INSERT INTO users (user_name, user_email, user_password) VALUES (?,?,?)";
    public static final String COUNT_USERS = "SELECT count(*) AS total FROM users";

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    @Override
    public User create(User user) {
        log.debug("Create user={} in table users ", user);
        return null;
    }

    @Override
    public List<User> findAll() {
        log.debug("Get all users from table users ");
        return jdbcTemplate.query(GET_ALL, this::mapRow);
    }

    @Override
    public User getUserByEmail(String email) {
        log.debug("Get user with email={} from table users ", email);
        return null;
    }

    @Override
    public User findById(Long id) {
        log.debug("Get user with id={} from table users ", id);
        return jdbcTemplate.queryForObject(GET_BY_ID, this::mapRow, id);
    }

    @Override
    public Long countAll() {
        log.debug("Count users");
        return 0L;
    }

    @Override
    public User update(User user) {
        log.debug("Update user ={} in table users ", user);
        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("user_name", user.getUserName());
        map.put("user_email", user.getUserEmail());
        map.put("user_password", user.getUserPassword());
        namedJdbcTemplate.update(UPDATE_BY_ID_NAMED, map);
        return findById(user.getId());
    }

    @Override
    public boolean delete(Long id) {
        log.debug("Delete user with id={} from table users ", id);
        return false;
    }

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUserName(rs.getString("user_name"));
        user.setUserEmail(rs.getString("user_email"));
        user.setUserPassword(rs.getString("user_password"));
        return user;
    }

}
