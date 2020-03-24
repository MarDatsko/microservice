package com.example.customerserver.controller;

import com.example.customerserver.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final RestTemplate restTemplate;

    @Autowired
    public CustomerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/products")
    public ResponseEntity getAllProducts() {
        String url = "http://storage-server/storage/all";
        List<?> productsList = restTemplate.getForObject(url, List.class);

        if (productsList == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(productsList);
    }

    @PostMapping("/buy/{id}")
    public ResponseEntity<Product> buyProduct(@PathVariable(name = "id") Long id) {
        String url = "http://storage-server/storage/delete/" + id;
        Product object = restTemplate.getForObject(url, Product.class);

        if (object == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(object);
    }
}
