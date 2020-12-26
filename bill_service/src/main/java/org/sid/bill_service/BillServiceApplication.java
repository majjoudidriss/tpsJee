package org.sid.bill_service;

import org.sid.bill_service.entities.Bill;
import org.sid.bill_service.entities.ProductItem;
import org.sid.bill_service.model.Customer;
import org.sid.bill_service.model.Product;
import org.sid.bill_service.repositorie.BillRepositorie;
import org.sid.bill_service.repositorie.ProductItemRepositorie;
import org.sid.bill_service.service.CustomerRestClient;
import org.sid.bill_service.service.ProductItemRestClinet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BillServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepositorie billRepositorie, ProductItemRepositorie productItemRepositorie
            , CustomerRestClient customerRestClient,
                            ProductItemRestClinet productItemRestClinet)
    {
        return args -> {
            Customer customer=customerRestClient.getCustomerById(1L);
            Bill bill1=billRepositorie.save(new Bill(null,new Date(),null,customer.getId(),null));
            PagedModel<Product> productPagedModel=productItemRestClinet.pageProducts();
            productPagedModel.forEach(p->{

                ProductItem productItem=new ProductItem();
                productItem.setId(p.getId());
                productItem.setPrice(p.getPrice());
                productItem.setProductID(p.getId());
                productItem.setQuantity(1+new Random().nextInt(100));
                productItem.setBill(bill1);
                productItemRepositorie.save(productItem);
            });
            System.out.println(bill1.getProductItems());

        };

    }

}
