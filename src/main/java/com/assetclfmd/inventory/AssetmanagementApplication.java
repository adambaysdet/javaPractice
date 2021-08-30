package com.assetclfmd.inventory;

import com.assetclfmd.inventory.entity.Person;
import com.assetclfmd.inventory.entity.Product;
import com.assetclfmd.inventory.repository.ProductRepository;
import com.assetclfmd.inventory.service.PersonService;
import com.assetclfmd.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssetmanagementApplication {

	@Autowired
	private static ProductService service;

	public static void main(String[] args) {

		SpringApplication.run(AssetmanagementApplication.class, args);

	}

}
