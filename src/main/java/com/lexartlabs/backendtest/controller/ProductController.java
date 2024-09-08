package com.lexartlabs.backendtest.controller;

import com.lexartlabs.backendtest.domain.Product;
import com.lexartlabs.backendtest.dto.request.InsertProductsRequest;
import com.lexartlabs.backendtest.dto.response.GetProductByIdResponse;
import com.lexartlabs.backendtest.dto.response.InsertProductsRequestResponse;
import com.lexartlabs.backendtest.dto.response.ProductDataResponse;
import com.lexartlabs.backendtest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @CrossOrigin
    @PostMapping
    ResponseEntity<InsertProductsRequestResponse> createProduct(@RequestBody List<InsertProductsRequest> products) {
        Integer count = productService.insertProducts(products);
        InsertProductsRequestResponse response = new InsertProductsRequestResponse("success","Products inserted successfully",count);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping
    ResponseEntity<String> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) String color)
            {
        return new ResponseEntity<>("hola", HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/:{productId}")
    ResponseEntity<GetProductByIdResponse> getProductsByName(@PathVariable("productId") String productId) {
        Product product = productService.getProductById(productId);
        List<ProductDataResponse> productDataResponse = new ArrayList<>();
        product.getData().forEach(data -> {
            ProductDataResponse productData = new ProductDataResponse();
            productData.setPrice(data.getPrice());
            productData.setColor(data.getColor());
            productDataResponse.add(productData);
        });

        GetProductByIdResponse response = new GetProductByIdResponse(product.getName(),product.getBrand(),product.getModel(),productDataResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
