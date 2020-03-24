package com.example.storageserver.controller;

import com.example.storageserver.database.Storage;
import com.example.storageserver.entity.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
@Log4j2
public class StorageController {

    private final Storage storage;

    @Autowired
    public StorageController(Storage storage) {
        this.storage = storage;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = storage.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id") Long id) {
        Product product = storage.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        storage.addProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(name = "id") Long id) {
        Product delete = storage.delete(id);
        return ResponseEntity.ok(delete);
    }
}
