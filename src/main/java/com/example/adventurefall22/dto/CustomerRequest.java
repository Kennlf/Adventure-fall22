package com.example.adventurefall22.dto;

import com.example.adventurefall22.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    private int phoneNumber;

    private String name;

    private String email;

    private int cvr;

    private int companyName;

    public static Customer getCustomerEntity(CustomerRequest c){
        return new Customer(c.phoneNumber, c.name, c.email, c.cvr, c.companyName);
    }

}
