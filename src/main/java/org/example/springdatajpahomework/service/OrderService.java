package org.example.springdatajpahomework.service;

import org.example.springdatajpahomework.model.dto.request.OrderRequest;
import org.example.springdatajpahomework.model.dto.response.OrderResponse;
import org.example.springdatajpahomework.model.enums.Status;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(Long customerId, List<OrderRequest> orderRequests);

    List<OrderResponse> getOrderByCustomerId(Long customerId);

    OrderResponse getOrderByOrderId(Long orderId);

    OrderResponse updateOrderStatus(Status status, Long orderId);
}
