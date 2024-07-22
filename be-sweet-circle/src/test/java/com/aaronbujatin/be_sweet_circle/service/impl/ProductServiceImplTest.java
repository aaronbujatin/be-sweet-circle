package com.aaronbujatin.be_sweet_circle.service.impl;

import com.aaronbujatin.be_sweet_circle.mapper.ProductMapper;
import com.aaronbujatin.be_sweet_circle.repository.ProductRepository;
import com.aaronbujatin.be_sweet_circle.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductMapper productMapper;
    private ProductService productService;

    @BeforeEach
    void setUp(){
        productService = new ProductServiceImpl(productRepository, productMapper);
    }

    @Test
    void shouldGetAllTheProduct(){
        //when
        productService.findAllProducts();

        //then
        verify(productRepository).findAll();
    }


}