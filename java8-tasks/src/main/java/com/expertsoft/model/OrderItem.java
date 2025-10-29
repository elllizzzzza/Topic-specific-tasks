package com.expertsoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderItem {

    public OrderItem () {}

    private Product product;
    private Integer quantity;
}
