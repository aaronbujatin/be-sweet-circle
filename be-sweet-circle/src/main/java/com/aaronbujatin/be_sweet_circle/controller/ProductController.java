package com.aaronbujatin.be_sweet_circle.controller;

import com.aaronbujatin.be_sweet_circle.dto.ProductDto;
import com.aaronbujatin.be_sweet_circle.enums.ProductMenu;
import com.aaronbujatin.be_sweet_circle.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private final ProductService productService;

    @PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
    public void saveProduct(@RequestParam(name = "name") String name,
                            @RequestParam(name = "price") BigDecimal price,
                            @RequestParam(name = "productMenu") ProductMenu productMenu,
                            @RequestParam(name = "description") String description,
                            @RequestParam(name = "stock") int stock,
                            @RequestParam(name = "image")MultipartFile multipartFile){
        try {
            ProductDto productDto = new ProductDto(name, price, description, stock, productMenu, multipartFile.getBytes());
            productService.createProduct(productDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> findAllFilterProducts(@RequestParam(required = false) String name){
        return ResponseEntity.ok(productService.findAllFilterProducts(name));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(productService.getAllProduct(page, size));
    }

    @PutMapping()
    public ResponseEntity<ProductDto> updateProduct(@RequestParam(name = "id") Long id,
                                                    @RequestParam(name = "name") String name,
                                                    @RequestParam(name = "price") BigDecimal price,
                                                    @RequestParam(name = "productMenu") ProductMenu productMenu,
                                                    @RequestParam(name = "description") String description,
                                                    @RequestParam(name = "stock") int stock,
                                                    @RequestParam(name = "image")MultipartFile multipartFile){
        try {
            ProductDto productDto = new ProductDto(id,name, price, description, stock, productMenu, multipartFile.getBytes());
            return ResponseEntity.ok(productService.updateProduct(productDto));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable(name = "id") Long id){
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

}
