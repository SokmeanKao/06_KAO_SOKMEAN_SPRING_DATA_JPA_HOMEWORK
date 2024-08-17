package org.example.springdatajpahomework.model.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.example.springdatajpahomework.model.entity.Customer;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailResponse {
    private Long id;
    private String email;
}
