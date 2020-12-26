package org.sid.bill_service.service;

import org.sid.bill_service.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductItemRestClinet
{
    @GetMapping(path = "/products")
    PagedModel<Product> pageProducts();
    @GetMapping(path="/products/{id}")
    public Product getProductById(Long id);
}
