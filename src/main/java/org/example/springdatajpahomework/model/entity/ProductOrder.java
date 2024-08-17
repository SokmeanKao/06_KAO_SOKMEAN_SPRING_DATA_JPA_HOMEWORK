package org.example.springdatajpahomework.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springdatajpahomework.model.dto.response.ProductOrderResponse;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductOrder {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Long quantity;

    public ProductOrderResponse toResponse() {
        return new ProductOrderResponse(this.id, this.product.getProductName(), this.product.getUnitPrice(),this.product.getDescription(), this.quantity);
    }

}
