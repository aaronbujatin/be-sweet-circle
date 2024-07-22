package com.aaronbujatin.be_sweet_circle.service.impl;

import com.aaronbujatin.be_sweet_circle.dto.ProductDto;
import com.aaronbujatin.be_sweet_circle.entity.Product;
import com.aaronbujatin.be_sweet_circle.exception.ProductNotFoundException;
import com.aaronbujatin.be_sweet_circle.mapper.ProductMapper;
import com.aaronbujatin.be_sweet_circle.repository.ProductRepository;
import com.aaronbujatin.be_sweet_circle.service.ProductService;
import com.aaronbujatin.be_sweet_circle.specification.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        product.setProductMenu(productDto.getProductMenu());
        product.setDescription(productDto.getDescription());
        product.setStock(productDto.getStock());
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
                         product.getStock(),
                         product.getProductMenu(),
                         product.getImage()))
                .orElseThrow(() -> new ProductNotFoundException("Product id " + id + " was not found!"));
    }

    @Override
    public Page<ProductDto> getAllProduct(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(product -> new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getStock(),
                product.getProductMenu(),
                product.getImage()));

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

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product id " + id + " was not found!"));
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product existingProduct = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new ProductNotFoundException("Product id " + productDto.getId() + " was not found!"));

        existingProduct.setName(productDto.getName());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setStock(productDto.getStock());
        existingProduct.setProductMenu(productDto.getProductMenu());
        existingProduct.setImage(productDto.getImage());

        productRepository.save(existingProduct);
        return productMapper.fromProduct(existingProduct);
    }


}
