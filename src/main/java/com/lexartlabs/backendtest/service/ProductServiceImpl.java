package com.lexartlabs.backendtest.service;

import com.lexartlabs.backendtest.domain.Data;
import com.lexartlabs.backendtest.domain.Product;
import com.lexartlabs.backendtest.dto.request.InsertProductsRequest;
import com.lexartlabs.backendtest.repository.ProductRepository;
import com.lexartlabs.backendtest.repository.ProductSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Integer insertProducts(List<InsertProductsRequest> productsRequests){
        List<Product> products = productsRequestToProducts(productsRequests);
        Iterable<Product> inserted = productRepository.saveAll(products);

        return products.size();
    }

    @Override
    public Product getProductById(String productId) {
        // TODO: tirar excepcion
        return productRepository.findById(Long.parseLong(productId)).orElse(null);
    }

    @Override
    public List<Product> getAllProducts(String name, String brand, String model) {
        Specification<Product> spec = Specification
                .where(ProductSpecifications.hasName(name))
                .and(ProductSpecifications.hasBrand(brand))
                .and(ProductSpecifications.hasModel(model));

        return productRepository.findAll(spec);
    }

    private List<Product> productsRequestToProducts(List<InsertProductsRequest> insertProductsRequest){
        List<Product> products = new ArrayList<>();
        insertProductsRequest.forEach(productsRequest -> {
            Product product = new Product();
            List<Data> data = new ArrayList<>();
            productsRequest.getData().forEach( requestProductData ->{
                Data productData = new Data(requestProductData.getPrice(), requestProductData.getColor(),product);
                data.add(productData);
            });
            product.setBrand(productsRequest.getBrand());
            product.setModel(productsRequest.getModel());
            product.setName(productsRequest.getName());
            product.setData(data);
            products.add(product);
        });
        return products;
    }
}
