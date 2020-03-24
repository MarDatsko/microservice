package com.example.storageserver;

import com.example.storageserver.database.Storage;
import com.example.storageserver.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class StorageServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageServerApplication.class, args);
    }

}
