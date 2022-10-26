package com.silverdoodle.silverdoodle.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductDto {

    @NotBlank
    @Size(max = 255)
    private String name;
    @NotBlank
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
