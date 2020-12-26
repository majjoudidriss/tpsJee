package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryserviceApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(ProductRepositorie productRepositorie, RepositoryRestConfiguration restConfiguration){
    restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepositorie.save(new Product(null,"produit1",Math.random()*1000,(int)(Math.random()*100)));
            productRepositorie.save(new Product(null,"produit2",Math.random()*1000,(int)(Math.random()*100)));
            productRepositorie.save(new Product(null,"produit3",Math.random()*1000,(int)(Math.random()*100)));
            productRepositorie.findAll().forEach(product -> {
                System.out.println(product);
            });
        };
    }
}
