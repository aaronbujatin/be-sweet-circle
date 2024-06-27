package com.aaronbujatin.be_sweet_circle.controller;

import com.aaronbujatin.be_sweet_circle.dto.ProductDto;
import com.aaronbujatin.be_sweet_circle.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
    public void saveProduct(@RequestParam(name = "name") String name,
                            @RequestParam(name = "price") BigDecimal price,
                            @RequestParam(name = "description") String description,
                            @RequestParam(name = "image")MultipartFile multipartFile){
        try {
            ProductDto productDto = new ProductDto(name, price, description);
            productDto.setImage(multipartFile.getBytes());
            productService.createProduct(productDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
