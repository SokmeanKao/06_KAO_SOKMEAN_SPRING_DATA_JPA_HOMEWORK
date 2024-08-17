package org.example.springdatajpahomework.service;

import org.example.springdatajpahomework.model.dto.request.CustomerRequest;
import org.example.springdatajpahomework.model.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> getAllCustomer(Integer pageNo, Integer pageSize, String sortBy, String sortDirection);

    CustomerResponse createCustomer(CustomerRequest customerRequest);

    CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest);

    CustomerResponse getCustomerById(Long id);

    void deleteCustomer(Long id);
}
