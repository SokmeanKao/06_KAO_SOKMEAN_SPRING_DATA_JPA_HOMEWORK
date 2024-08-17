package org.example.springdatajpahomework.model.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private Long quantity;
    private Long productId;
}
