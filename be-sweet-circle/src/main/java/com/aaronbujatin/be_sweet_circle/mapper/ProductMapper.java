package com.aaronbujatin.be_sweet_circle.mapper;

import com.aaronbujatin.be_sweet_circle.dto.ProductDto;
import com.aaronbujatin.be_sweet_circle.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductDto productDto){
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .stock(productDto.getStock())
                .productMenu(productDto.getProductMenu())
                .image(productDto.getImage())
                .build();
    }

    public ProductDto fromProduct(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .productMenu(product.getProductMenu())
                .description(product.getDescription())
                .stock(product.getStock())
                .image(product.getImage())
                .build();
    }

}
