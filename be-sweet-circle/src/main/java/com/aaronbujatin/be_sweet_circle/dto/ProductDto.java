package com.aaronbujatin.be_sweet_circle.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private byte[] image;

    public ProductDto(Long id, String name, BigDecimal price, String description, byte[] image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public ProductDto(String name, BigDecimal price, String description, byte[] image) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
