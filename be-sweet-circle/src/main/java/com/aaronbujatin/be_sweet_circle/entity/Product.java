package com.aaronbujatin.be_sweet_circle.entity;

import com.aaronbujatin.be_sweet_circle.enums.ProductMenu;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private int stock;
    @Enumerated(EnumType.STRING)
    private ProductMenu productMenu;
    @Column(length = 100_000)
    private byte[] image;

}
