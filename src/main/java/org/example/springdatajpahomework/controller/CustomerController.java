package org.example.springdatajpahomework.controller;

import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.dto.request.CustomerRequest;
import org.example.springdatajpahomework.model.dto.response.CustomerResponse;
import org.example.springdatajpahomework.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerResponse> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @PostMapping()
    public CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.createCustomer(customerRequest);
    }

    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest){
        return customerService.updateCustomer(id, customerRequest);
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }

}
