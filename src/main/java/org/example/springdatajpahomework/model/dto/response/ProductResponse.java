package org.example.springdatajpahomework.model.dto.response;

import jakarta.persistence.OneToMany;
import lombok.*;
import org.example.springdatajpahomework.model.entity.ProductOrder;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Long productId;
    private String productName;
    private Float unitPrice;
    private String description;
}
