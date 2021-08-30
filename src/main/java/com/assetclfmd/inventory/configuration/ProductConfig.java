package com.assetclfmd.inventory.configuration;

import com.assetclfmd.inventory.entity.Product;
import com.assetclfmd.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Autowired
    private ProductRepository repository;
    @Bean
    public void addProduct(){
        Product p1= new Product();
        p1.setQuantity(49);
        p1.setName("paper");
        p1.setPrice(1985);

        Product p2= new Product();
        p2.setQuantity(13);
        p2.setName("drink");
        p2.setPrice(1999);

        repository.saveAll(List.of(p1,p2));

    }
}
