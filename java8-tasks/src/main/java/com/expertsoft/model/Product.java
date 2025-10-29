package com.expertsoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    public enum Color {
        WHITE,
        BLACK,
        RED,
        BLUE,
        YELLOW
    }

    private Long id;
    private String name;
    private Color color;
    private BigDecimal price;


    @Override
    public String toString() {
        return "Product #" + id + " (" + name + ")";
    }
}
