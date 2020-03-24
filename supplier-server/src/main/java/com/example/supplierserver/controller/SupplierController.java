package com.example.supplierserver.controller;

import com.example.supplierserver.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final RestTemplate restTemplate;

    @Autowired
    public SupplierController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/products")
    public ResponseEntity<List<?>> getAllProducts() {
        String url = "http://storage-server/storage/all";
        List<?> productsList = restTemplate.getForObject(url, List.class);

        if (productsList == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(productsList);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
        String url = "http://storage-server/storage/add";
        Product returnProduct = restTemplate.postForObject(url, product, Product.class);

        if (returnProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(returnProduct);
    }
}
