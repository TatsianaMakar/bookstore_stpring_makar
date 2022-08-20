package com.company.repository.entity;

import java.util.Objects;

public class User {
    private Long id;
    private String userName;
    private String userEmail;
    private String userPassword;

    public User() {
    }

    public User(Long id, String user_name, String user_email, String user_password) {
        this.id = id;
        this.userName = user_name;
        this.userEmail = user_email;
        this.userPassword = user_password;
    }

    public User(String user_name, String user_email, String user_password) {
        this.userName = user_name;
        this.userEmail = user_email;
        this.userPassword = user_password;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(userName, user.userName) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userPassword, user.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userEmail, userPassword);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + userName + '\'' +
                ", user_email='" + userEmail + '\'' +
                ", user_password='" + userPassword + '\'' +
                '}';
    }
}
