package com.lexartlabs.backendtest.service;

import com.lexartlabs.backendtest.domain.Product;
import com.lexartlabs.backendtest.dto.request.InsertProductsRequest;

import java.util.List;

public interface ProductService {
    Integer insertProducts(List<InsertProductsRequest> productsRequests);
    Product getProductById(String productId);
}

