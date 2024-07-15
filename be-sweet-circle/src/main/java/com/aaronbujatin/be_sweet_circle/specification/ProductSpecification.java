package com.aaronbujatin.be_sweet_circle.specification;

import com.aaronbujatin.be_sweet_circle.entity.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

public class ProductSpecification {

    public static Specification<Product> filterProduct(String name){
        return (root, query, criteriaBuilder) -> {
            Predicate productNamePredicate =  criteriaBuilder
                    .like(root.get("name"), StringUtils.isBlank(name) ? likePattern("") : name);
            return criteriaBuilder.and(productNamePredicate);
        };
    }
    private static String likePattern(String value) {
        return "%" + value + "%";
    }
}
