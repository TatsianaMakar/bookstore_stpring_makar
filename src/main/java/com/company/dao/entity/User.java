package com.company.dao.entity;

import lombok.*;

@Data
public class User {
    private Long id;
    private String userName;
    private String userEmail;
    private String userPassword;
}
