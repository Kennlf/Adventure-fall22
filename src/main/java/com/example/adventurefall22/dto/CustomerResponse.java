package com.example.adventurefall22.dto;

import com.example.adventurefall22.entity.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {

    private int phoneNumber;

    private String name;

    private String email;

    private int cvr;

    private int companyName;

    public CustomerResponse(Customer customer) {
        this.phoneNumber = customer.getPhoneNumber();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.cvr = customer.getCvr();
        this.companyName = customer.getCompanyName();
    }
}
