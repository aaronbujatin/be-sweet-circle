package com.aaronbujatin.be_sweet_circle.entity;

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
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_seq"
    )
    @SequenceGenerator(
            name = "product_seq",
            sequenceName = "tbl_product_seq",
            allocationSize = 1
    )

//    name,
//    menu(DONUTS, BEVERAGES),
//    category(CLASSIC_DONUT, PREMIUM_DONUT)
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    @Column(length = 100_000)
    private byte[] image;


}
