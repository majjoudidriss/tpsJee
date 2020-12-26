package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositories.CustomerRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerserviceApplication.class, args);
    }

@Bean
    public CommandLineRunner start(CustomerRepositorie customerRepositorie, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Customer.class);
        return args ->{
            customerRepositorie.save (new Customer(null,"idriss","idriis@"));

            customerRepositorie.save (new Customer(null,"oussama"," ouss@"));

            customerRepositorie.save (new Customer(null,"ahmed"," med@"));
            customerRepositorie.findAll().forEach(customer -> {
                System.out.println(customer.getName());
            } );
        };
    }
}
