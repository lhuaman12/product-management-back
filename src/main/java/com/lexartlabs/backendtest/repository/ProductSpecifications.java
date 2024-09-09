package com.lexartlabs.backendtest.repository;

import com.lexartlabs.backendtest.domain.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {

    public static Specification<Product> hasName(String name) {
        return (root, query, cb) -> name == null ? null : cb.equal(root.get("name"), name);
    }

    public static Specification<Product> hasBrand(String brand) {
        return (root, query, cb) -> brand == null ? null : cb.equal(root.get("brand"), brand);
    }

    public static Specification<Product> hasModel(String model) {
        return (root, query, cb) -> model == null ? null : cb.equal(root.get("model"), model);
    }
}