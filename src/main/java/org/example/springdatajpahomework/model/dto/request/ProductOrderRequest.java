package org.example.springdatajpahomework.model.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOrderRequest {
    private Long productId;
    private Long quantity;
}

