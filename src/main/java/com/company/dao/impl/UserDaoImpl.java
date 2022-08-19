package com.company.dao.impl;

import com.company.dao.connection.DataSourse;
import com.company.dao.UserDao;
import com.company.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final DataSourse dataSourse;
    public static final String GET_ALL = "SELECT id, user_name, user_email, user_password FROM users";
    public static final String GET_BY_EMAIL = "SELECT id, user_name, user_email, user_password FROM users WHERE user_email=?";
    public static final String GET_BY_ID = "SELECT id, user_name, user_email, user_password FROM users WHERE id=?";
    public static final String DELETE_BY_ID = "DELETE FROM users WHERE id=?";
    public static final String UPDATE_BY_ID = "UPDATE users SET user_name=?, user_email=?, user_password=? WHERE id=?";
    public static final String ADD_NEW_USER = "INSERT INTO users (user_name, user_email, user_password) VALUES (?,?,?)";
    public static final String COUNT_USERS = "SELECT count(*) AS total FROM users";

    public UserDaoImpl(DataSourse dataSourse) {
        this.dataSourse = dataSourse;
    }

    @Override
    public User create(User user) {
        try {
            Connection connection = dataSourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(ADD_NEW_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserEmail());
            statement.setString(3, user.getUserPassword());
            if (statement.executeUpdate() == 1) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    Long id = resultSet.getLong(1);
                    return findById(id);
                }
            }
        } catch (
                SQLException e) {
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = dataSourse.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserEmail(resultSet.getString("user_email"));
                user.setUserPassword(resultSet.getString("user_password"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println("something wrong...");
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        try {
            Connection connection = dataSourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserEmail(resultSet.getString("user_email"));
                user.setUserPassword(resultSet.getString("user_password"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("something wrong...");
        }
        return null;
    }

    @Override
    public User findById(Long id) {
        try {
            Connection connection = dataSourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserEmail(resultSet.getString("user_email"));
                user.setUserPassword(resultSet.getString("user_password"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("something wrong...");
        }
        return null;
    }

    @Override
    public Long countAll() {
        try {
            Connection connection = dataSourse.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(COUNT_USERS);
            if (resultSet.next()) {
                return resultSet.getLong("total");
            }
        } catch (SQLException e) {
            System.out.println("something wrong...");
        }
        throw new RuntimeException("Something wrong");
    }

    @Override
    public User update(User user) {
        try {
            Connection connection = dataSourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID);
            statement.setLong(4, user.getId());
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserEmail());
            statement.setString(3, user.getUserPassword());
            if (statement.executeUpdate() == 1) {
                return getUserByEmail(user.getUserEmail());
            }
        } catch (SQLException e) {
            System.out.println("something wrong...");
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        try {
            Connection connection = dataSourse.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setLong(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("something wrong...");
        }
        return false;
    }
}
