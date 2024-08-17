package org.example.springdatajpahomework.model.dto.request;

import lombok.*;
import org.example.springdatajpahomework.model.entity.Customer;
import org.example.springdatajpahomework.model.entity.Email;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {
    private String customerName;
    private String address;
    private String phoneNumber;
    private String email;

    public Customer toEntity(Email email){
        return new Customer(null, this.customerName, this.address, this.phoneNumber, email , null );
    }
    public Customer toEntity(Long id, Email email){
        return new Customer(id, this.customerName, this.address, this.phoneNumber, email , null );
    }
}

