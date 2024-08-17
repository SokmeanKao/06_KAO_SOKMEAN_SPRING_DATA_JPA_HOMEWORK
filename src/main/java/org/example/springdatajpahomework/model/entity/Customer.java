package org.example.springdatajpahomework.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.springdatajpahomework.model.dto.response.CustomerResponse;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String address;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    private Email email;
    @OneToMany(mappedBy = "customer")
    private List<Order> order;
    public CustomerResponse toResponse(){
        return new CustomerResponse(this.customerId , this.customerName, this.address, this.phoneNumber,this.email.toResponse());
    }
}
