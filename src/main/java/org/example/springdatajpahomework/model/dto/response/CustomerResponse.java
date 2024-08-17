package org.example.springdatajpahomework.model.dto.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
    private Long customerId;
    private String customerName;
    private String address;
    private String phoneNumber;
    private EmailResponse emailResponse;
}
