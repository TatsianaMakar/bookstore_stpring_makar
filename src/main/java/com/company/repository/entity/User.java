package com.company.repository.entity;

import lombok.*;

import java.util.Objects;

@Data
public class User {
    private Long id;
    private String userName;
    private String userEmail;
    private String userPassword;
}
