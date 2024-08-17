package org.example.springdatajpahomework.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.springdatajpahomework.model.dto.response.ProductResponse;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Float unitPrice;
    private String description;

    @OneToMany(mappedBy = "product")
    private List<ProductOrder> productOrderList;

    public ProductResponse toResponse(){
        return new ProductResponse(this.productId, this.productName, this.unitPrice, this.description);
    }
}
