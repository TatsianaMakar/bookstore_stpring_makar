package com.company.dao.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {
    private Long id;
    private Long bookId;
    private Integer quantity;
    private BigDecimal price;
    private Long orderId;
}
