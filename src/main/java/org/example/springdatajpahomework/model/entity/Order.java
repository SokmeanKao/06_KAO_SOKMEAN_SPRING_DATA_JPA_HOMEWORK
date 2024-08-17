package org.example.springdatajpahomework.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springdatajpahomework.model.dto.response.OrderResponse;
import org.example.springdatajpahomework.model.dto.response.ProductOrderResponse;
import org.example.springdatajpahomework.model.enums.Status;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_tb")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @JsonFormat(pattern = "yyy-MM-dd")
    private LocalDateTime orderDate;

    private Float totalAmount;
    private Status status;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOrder> productOrder;


    public OrderResponse toResponse() {
        List<ProductOrderResponse> productOrderList = this.productOrder.stream()
                .map(ProductOrder::toResponse)
                .collect(Collectors.toList());

        return new OrderResponse(this.orderId, this.orderDate, this.totalAmount, this.status, productOrderList);
    }
}
