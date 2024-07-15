package com.aaronbujatin.be_sweet_circle.service;

import com.aaronbujatin.be_sweet_circle.dto.ProductDto;
import com.aaronbujatin.be_sweet_circle.entity.Product;

import java.util.List;

public interface ProductService {

    void createProduct(ProductDto productDto);
    ProductDto findProductById(Long id);
    List<ProductDto> findAllProducts();
    List<ProductDto> findAllFilterProducts(String name);


}
