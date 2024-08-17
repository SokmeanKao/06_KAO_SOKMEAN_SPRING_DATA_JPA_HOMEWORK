package org.example.springdatajpahomework.controller;

import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.dto.request.OrderRequest;
import org.example.springdatajpahomework.model.dto.response.ApiResponse;
import org.example.springdatajpahomework.model.dto.response.OrderResponse;
import org.example.springdatajpahomework.model.enums.Status;
import org.example.springdatajpahomework.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/{customerId}")
    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(@PathVariable("customerId") Long customerId, @RequestBody List<OrderRequest> orderRequests){
        ApiResponse<OrderResponse> response = ApiResponse.<OrderResponse>builder()
                .message("Create order successfully!")
                .payload(orderService.createOrder(customerId, orderRequests))
                .status(HttpStatus.CREATED)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ApiResponse<List<OrderResponse>>> getOrderByCustomerId(@PathVariable("customerId") Long customerId){
        ApiResponse<List<OrderResponse>> response = ApiResponse.<List<OrderResponse>>builder()
                .message("Get order successfully!")
                .payload(orderService.getOrderByCustomerId(customerId))
                .status(HttpStatus.OK)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<ApiResponse<OrderResponse>> getOrderByOrderId(@PathVariable("orderId") Long orderId){
        ApiResponse<OrderResponse> response = ApiResponse.<OrderResponse>builder()
                .message("Get order successfully!")
                .payload(orderService.getOrderByOrderId(orderId))
                .status(HttpStatus.OK)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/status")
    public ResponseEntity<ApiResponse<OrderResponse>> updateOrderStatus(@RequestParam("status") Status status, @RequestParam Long orderId){
        ApiResponse<OrderResponse> response = ApiResponse.<OrderResponse>builder()
                .message("Update order successfully!")
                .payload(orderService.updateOrderStatus(status, orderId))
                .status(HttpStatus.OK)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
