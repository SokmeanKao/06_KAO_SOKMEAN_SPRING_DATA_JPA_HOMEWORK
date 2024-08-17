package org.example.springdatajpahomework.controller;

import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.dto.request.CustomerRequest;
import org.example.springdatajpahomework.model.dto.response.ApiResponse;
import org.example.springdatajpahomework.model.dto.response.CustomerResponse;
import org.example.springdatajpahomework.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerResponse>>> getAllCustomer(@RequestParam(required = false,defaultValue = "0") Integer pageNo,
                                                                             @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                                                                             @RequestParam(required = false, defaultValue = "name") String sortBy,
                                                                             @RequestParam(required = false, defaultValue = "DESC") String sortDirection){
        ApiResponse<List<CustomerResponse>> response = ApiResponse.<List<CustomerResponse>>builder()
                .message("Get customers successfully!")
                .payload(customerService.getAllCustomer(pageNo, pageSize, sortBy, sortDirection))
                .status(HttpStatus.OK)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CustomerResponse>> createCustomer(@RequestBody CustomerRequest customerRequest){
        ApiResponse<CustomerResponse> response = ApiResponse.<CustomerResponse>builder()
                .message("Create customer successfully!")
                .payload(customerService.createCustomer(customerRequest))
                .status(HttpStatus.CREATED)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponse>> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest){
        ApiResponse<CustomerResponse> response = ApiResponse.<CustomerResponse>builder()
                .message("Update customer successfully!")
                .payload(customerService.updateCustomer(id, customerRequest))
                .status(HttpStatus.OK)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponse>> getCustomerById(@PathVariable Long id){
        ApiResponse<CustomerResponse> response = ApiResponse.<CustomerResponse>builder()
                .message("Get customer successfully!")
                .payload(customerService.getCustomerById(id))
                .status(HttpStatus.OK)
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Remove Successfully!");
    }

}
