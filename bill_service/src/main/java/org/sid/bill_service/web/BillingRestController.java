package org.sid.bill_service.web;

import org.sid.bill_service.entities.Bill;
import org.sid.bill_service.model.Customer;
import org.sid.bill_service.model.Product;
import org.sid.bill_service.repositorie.BillRepositorie;
import org.sid.bill_service.repositorie.ProductItemRepositorie;
import org.sid.bill_service.service.CustomerRestClient;
import org.sid.bill_service.service.ProductItemRestClinet;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {
    private BillRepositorie billRepositorie;
    private ProductItemRepositorie productItemRepositorie;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClinet productItemRestClinet;

    public BillingRestController(BillRepositorie billRepositorie, ProductItemRepositorie productItemRepositorie, CustomerRestClient customerRestClient, ProductItemRestClinet productItemRestClinet) {
        this.billRepositorie = billRepositorie;
        this.productItemRepositorie = productItemRepositorie;
        this.customerRestClient = customerRestClient;
        this.productItemRestClinet = productItemRestClinet;
    }


    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id)
{
Bill bill=billRepositorie.findById(id).get();
    Customer customer=customerRestClient.getCustomerById(bill.getCustomerID());
    bill.setCustomer(customer);

    /*bill.getProductItems().forEach(pi->{
        Product product=productItemRestClinet.getProductById(pi.getProductID());
        pi.setProduct(product);
    });*/
    return  bill;
}
}
