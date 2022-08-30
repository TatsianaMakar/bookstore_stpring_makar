package com.company.dao.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String userName;
    private String userEmail;
    private String userPassword;
}
