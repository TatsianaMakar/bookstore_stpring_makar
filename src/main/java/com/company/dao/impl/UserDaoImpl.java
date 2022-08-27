package com.company.dao.impl;

import com.company.dao.UserDao;
import com.company.dao.dto.UserDto;
import com.company.dao.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
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
    public static final String GET_ALL = "SELECT id, user_name, user_email, user_password FROM users WHERE deleted=FALSE";
    public static final String GET_BY_EMAIL = "SELECT id, user_name, user_email, user_password FROM users WHERE user_email=? AND deleted=FALSE";
    public static final String GET_BY_ID = "SELECT id, user_name, user_email, user_password FROM users WHERE id=? AND deleted=FALSE";
    public static final String DELETE_BY_ID = "DELETE FROM users WHERE id=? AND deleted=FALSE";
    public static final String UPDATE_BY_ID = "UPDATE users SET user_name=?, user_email=?, user_password=? WHERE id=? AND deleted=FALSE";
    public static final String UPDATE_BY_ID_NAMED = "UPDATE users SET user_name=:user_name, user_email=:user_email, user_password=:user_password WHERE id=:id AND deleted=FALSE";
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
    public UserDto create(UserDto user) {
        log.debug("Create user={} in table users ", user);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(ADD_NEW_USER);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserEmail());
            ps.setString(3, user.getUserPassword());
            return ps;
        }, keyHolder);
        Number number = keyHolder.getKey();
        if (number != null) {
            long id = number.longValue();
            return findById(id);
        }
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        log.debug("Get all users from table users ");
        return jdbcTemplate.query(GET_ALL, this::mapRow);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        log.debug("Get user with email={} from table users ", email);
        return null;
    }

    @Override
    public UserDto findById(Long id) {
        log.debug("Get user with id={} from table users ", id);
        return jdbcTemplate.queryForObject(GET_BY_ID, this::mapRow, id);
    }

    @Override
    public Long countAll() {
        log.debug("Count users");
        return 0L;
    }

    @Override
    public UserDto update(UserDto user) {
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
        if (jdbcTemplate.update(DELETE_BY_ID, id) == 1) {
            return true;
        }
        return false;
    }

    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDto userDto = new UserDto();
        userDto.setId(rs.getLong("id"));
        userDto.setUserName(rs.getString("user_name"));
        userDto.setUserEmail(rs.getString("user_email"));
        userDto.setUserPassword(rs.getString("user_password"));
        return userDto;
    }

}
