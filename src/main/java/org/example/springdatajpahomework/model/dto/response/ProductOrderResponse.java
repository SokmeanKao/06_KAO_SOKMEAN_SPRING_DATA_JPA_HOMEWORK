package org.example.springdatajpahomework.model.dto.response;

import lombok.*;
import org.example.springdatajpahomework.model.entity.Product;
import org.example.springdatajpahomework.model.entity.ProductOrder;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductOrderResponse {
    private Long id;
    private String productName;
    private float unitPrice;
    private String description;
    private Long quantity;
}

