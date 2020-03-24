package com.example.storageserver.database;

import com.example.storageserver.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Storage {

    private static Map<Long,Product> productsList = new HashMap<>();

    static {
        Product milk = new Product(1L,"Milk","Fresh cow's milk", BigDecimal.valueOf(5));
        Product apple = new Product(2L,"Apple","Red apple", BigDecimal.valueOf(13));
        Product meat = new Product(3L,"Meat","Rotten meat", BigDecimal.valueOf(55));
        Product bread = new Product(4L,"Bread","Bread made of clay", BigDecimal.valueOf(23));
        Product flour = new Product(5L,"Flour","Gypsum flour", BigDecimal.valueOf(5));

        productsList.put(milk.getId(),milk);
        productsList.put(apple.getId(),apple);
        productsList.put(meat.getId(),meat);
        productsList.put(bread.getId(),bread);
        productsList.put(flour.getId(),flour);
    }

    public void addProduct(Product product){
        productsList.put(product.getId(),product);
    }

    public Product getProduct(Long id){
        return productsList.get(id);
    }

    public List<Product> getAllProducts(){
        ArrayList<Product> list = new ArrayList<>();
        for (var e : productsList.entrySet()){
           list.add(e.getValue());
        }
        return list;
    }

    public Product delete(Long id){
        return productsList.remove(id);
    }
}
