package com.lexartlabs.backendtest.controller;

import com.lexartlabs.backendtest.dto.request.InsertProductsRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductsController {

    @CrossOrigin
    @PostMapping
    ResponseEntity<String> createProduct(@RequestBody List<InsertProductsRequest> products) {
        products.forEach(product -> System.out.println(product.getName()));
        return new ResponseEntity<>("hola", HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping
    ResponseEntity<String> getProducts(@RequestParam(required = false) String product) {
        return new ResponseEntity<>("hola", HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/:{productId}")
    ResponseEntity<String> getProductsByName(@PathVariable("productId") String productId) {
        return new ResponseEntity<>("hola", HttpStatus.OK);
    }

}
