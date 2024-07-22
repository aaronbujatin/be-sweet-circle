package com.aaronbujatin.be_sweet_circle.service;

import com.aaronbujatin.be_sweet_circle.dto.ProductDto;
import com.aaronbujatin.be_sweet_circle.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    void createProduct(ProductDto productDto);
    ProductDto findProductById(Long id);
    Page<ProductDto> getAllProduct(int page, int size);
    List<ProductDto> findAllFilterProducts(String name);
    void deleteProductById(Long id);
    ProductDto updateProduct(ProductDto productDto);

}
