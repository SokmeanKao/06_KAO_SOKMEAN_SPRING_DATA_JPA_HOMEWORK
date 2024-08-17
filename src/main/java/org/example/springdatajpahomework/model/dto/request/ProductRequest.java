package org.example.springdatajpahomework.model.dto.request;

import lombok.*;
import org.example.springdatajpahomework.model.entity.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String productName;
    private Float unitPrice;
    private String description;

    public Product toEntity(){
        return new Product(null, this.productName, this.unitPrice, this.description, null);
    }
    public Product toEntity(Long id){
        return new Product(id, this.productName, this.unitPrice, this.description, null);
    }
}

