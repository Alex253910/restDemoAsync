package com.example.async.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private int itemId;
    private int quantity;
    private String description;
}
