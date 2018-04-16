package com.globomart.productcatalog.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.globomart.catalog.controllers"
	,"com.globomart.catalog.config"
	,"com.globomart.catalog.exceptions"
	,"com.globomart.catalog.service.impl"
	,"com.globomart.catalog.service"
})
@EnableJpaRepositories({"com.globomart.catalog.dao"
})
@EntityScan("com.globomart.catalog.models")

public class ProductCatalogManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogManagementApplication.class, args);
	}
}