package com.company.repository.impl;

import com.company.dao.dto.BookDto;
import com.company.dao.dto.UserDto;
import com.company.dao.entity.Book;
import com.company.dao.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapper {
    public BookDto toDto(Book entity) {
        BookDto dto = new BookDto();
        dto.setId(entity.getId());
        dto.setBookName(entity.getBookName());
        dto.setAuthor(entity.getAuthor());
        dto.setYear(entity.getYear());
        dto.setPrice(entity.getPrice());
        dto.setIsbn(entity.getIsbn());
        dto.setCover(entity.getCover());
        return dto;
    }

    public Book toEntity(BookDto dto) {
        Book entity = new Book();
        entity.setId(dto.getId());
        entity.setBookName(dto.getBookName());
        entity.setAuthor(dto.getAuthor());
        entity.setYear(dto.getYear());
        entity.setPrice(dto.getPrice());
        entity.setIsbn(dto.getIsbn());
        entity.setCover(dto.getCover());
        return entity;
    }

    public UserDto toDto(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUserName(entity.getUserName());
        dto.setUserEmail(entity.getUserEmail());
        dto.setUserPassword(entity.getUserPassword());
        return dto;
    }

    public User toEntity(UserDto dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setUserName(dto.getUserName());
        entity.setUserEmail(dto.getUserEmail());
        entity.setUserPassword(dto.getUserPassword());
        return entity;
    }
}
