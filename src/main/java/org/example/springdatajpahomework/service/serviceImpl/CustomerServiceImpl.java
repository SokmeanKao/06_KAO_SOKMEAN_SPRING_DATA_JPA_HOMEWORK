package org.example.springdatajpahomework.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.dto.request.CustomerRequest;
import org.example.springdatajpahomework.model.dto.response.CustomerResponse;
import org.example.springdatajpahomework.model.entity.Customer;
import org.example.springdatajpahomework.model.entity.Email;
import org.example.springdatajpahomework.repository.CustomerRepository;
import org.example.springdatajpahomework.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerResponse> getAllCustomer(Integer pageNo, Integer pageSize, String sortBy, String sortDirection) {
        return customerRepository.findAll().stream().map(Customer::toResponse).toList();
    }

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Email email = new Email(null, customerRequest.getEmail(), null);
        return customerRepository.save(customerRequest.toEntity(email)).toResponse();
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found!")).toResponse();
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest) {
        Email email = new Email(getCustomerById(id).getEmailResponse().getId(), customerRequest.getEmail(), null);
        return customerRepository.save(customerRequest.toEntity(id, email)).toResponse();
    }


}
