package org.example.springdatajpahomework.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.example.springdatajpahomework.model.entity.Customer;
import org.example.springdatajpahomework.model.entity.ProductOrder;
import org.example.springdatajpahomework.model.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Long orderId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime orderDate;
    private Float totalAmount;
    private Status status;
    private List<ProductOrderResponse> productOrderResponses;


}
