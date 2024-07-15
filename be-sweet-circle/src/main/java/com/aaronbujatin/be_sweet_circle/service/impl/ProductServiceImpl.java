package com.aaronbujatin.be_sweet_circle.service.impl;

import com.aaronbujatin.be_sweet_circle.dto.ProductDto;
import com.aaronbujatin.be_sweet_circle.entity.Product;
import com.aaronbujatin.be_sweet_circle.exception.ProductNotFoundException;
import com.aaronbujatin.be_sweet_circle.mapper.ProductMapper;
import com.aaronbujatin.be_sweet_circle.repository.ProductRepository;
import com.aaronbujatin.be_sweet_circle.service.ProductService;
import com.aaronbujatin.be_sweet_circle.specification.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        productRepository.save(product);
    }

    @Override
    public ProductDto findProductById(Long id) {
        return productRepository.findById(id)
                 .map(product -> new ProductDto(
                         product.getId(),
                         product.getName(),
                         product.getPrice(),
                         product.getDescription(),
                         product.getImage()))
                .orElseThrow(() -> new ProductNotFoundException("Product id " + id + " was not found!"));
    }

    @Override
    public List<ProductDto> findAllProducts() {
        return productRepository.findAll().stream().map(product -> new ProductDto( product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getImage())).toList();
    }

    @Override
    public List<ProductDto> findAllFilterProducts(String name) {
        final Specification<Product> productSpecification = ProductSpecification.filterProduct(name);
        final List<ProductDto> products = productRepository.findAll(productSpecification)
                .stream()
                .map(productMapper::fromProduct)
                .toList();
        return products;
    }


}
