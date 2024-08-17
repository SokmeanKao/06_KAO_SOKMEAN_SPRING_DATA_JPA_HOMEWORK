package org.example.springdatajpahomework.controller;

import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.dto.request.OrderRequest;
import org.example.springdatajpahomework.model.dto.response.OrderResponse;
import org.example.springdatajpahomework.model.enums.Status;
import org.example.springdatajpahomework.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/{customerId}")
    public OrderResponse createOrder(@PathVariable Long customerId, @RequestBody List<OrderRequest> orderRequests){
        return orderService.createOrder(customerId, orderRequests);
    }

    @GetMapping("/customer/{customerId}")
    public List<OrderResponse> getOrderByCustomerId(@PathVariable Long customerId){
        return orderService.getOrderByCustomerId(customerId);
    }

    @GetMapping("/{orderId}")
    public OrderResponse getOrderByOrderId(@PathVariable Long orderId){
        return orderService.getOrderByOrderId(orderId);
    }

    @PutMapping("/status")
    public OrderResponse updateOrderStatus(@RequestParam("status") Status status, @RequestParam Long orderId){
        return orderService.updateOrderStatus(status, orderId);
    }


}
