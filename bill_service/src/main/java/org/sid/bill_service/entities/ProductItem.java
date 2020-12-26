package org.sid.bill_service.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bill_service.model.Product;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double quantity;
    private double price;
        private  Long productID;
        @ManyToOne
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Bill bill;
        @Transient
    private Product product;
}
