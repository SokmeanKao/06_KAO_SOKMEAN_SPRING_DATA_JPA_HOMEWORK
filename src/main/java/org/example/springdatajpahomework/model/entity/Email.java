package org.example.springdatajpahomework.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springdatajpahomework.model.dto.response.EmailResponse;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    @OneToOne(mappedBy = "email",cascade = CascadeType.ALL)
    private Customer customer;

    public EmailResponse toResponse(){
        return new EmailResponse(this.id, this.email);
    }

}
