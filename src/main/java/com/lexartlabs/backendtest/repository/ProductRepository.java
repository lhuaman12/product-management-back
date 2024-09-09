package com.lexartlabs.backendtest.repository;

import com.lexartlabs.backendtest.domain.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
