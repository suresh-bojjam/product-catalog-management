package com.globomart.catalog.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.globomart.catalog.models.Product;
import com.globomart.catalog.models.Product_;

public class ProductSpecification {

    public static Specification<Product> productNameIsLike(final String searchTerm) {
        
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> ProductRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                String likePattern = getLikePattern(searchTerm);
                return cb.like(cb.lower(ProductRoot.<String>get(Product_.productName)), likePattern);
            }
            
            private String getLikePattern(final String searchTerm) {
                StringBuilder pattern = new StringBuilder();
                pattern.append(searchTerm.toLowerCase());
                pattern.append("%");
                return pattern.toString();
            }
        };
    }
    
    public static Specification<Product> productDescIsLike(final String searchTerm) {
        
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> ProductRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
                String likePattern = getLikePattern(searchTerm);
                return cb.like(cb.lower(ProductRoot.<String>get(Product_.productDescription)), likePattern);
            }
            
            private String getLikePattern(final String searchTerm) {
                StringBuilder pattern = new StringBuilder();
                pattern.append(searchTerm.toLowerCase());
                pattern.append("%");
                return pattern.toString();
            }
        };
    }
}