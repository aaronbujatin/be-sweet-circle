package com.aaronbujatin.be_sweet_circle.specification;

import com.aaronbujatin.be_sweet_circle.entity.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

public class ProductSpecification {

    public static Specification<Product> filterProduct(String name){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + name.toLowerCase() + "%"
                );
    }

    private static String likePattern(String value) {
        return "%" + value + "%";
    }
}
