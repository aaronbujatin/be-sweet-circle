package com.aaronbujatin.be_sweet_circle.dto;

import com.aaronbujatin.be_sweet_circle.enums.ProductMenu;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private int stock;
    private ProductMenu productMenu;
    @Lob
    private byte[] image;

    public ProductDto(String name, BigDecimal price, String description, int stock, ProductMenu productMenu, byte[] image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.productMenu = productMenu;
        this.image = image;
    }
}
