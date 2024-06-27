package com.aaronbujatin.be_sweet_circle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_seq"
    )
    @SequenceGenerator(
            name = "product_seq",
            sequenceName = "tbl_product_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    @Column(length = 100_000)
    private byte[] image;


}
