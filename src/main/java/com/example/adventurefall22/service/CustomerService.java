package com.example.adventurefall22.service;

import com.example.adventurefall22.dto.CustomerRequest;
import com.example.adventurefall22.entity.Customer;
import com.example.adventurefall22.repository.CustomerRepository;

public class CustomerService {

    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void makeCustomer(Customer customer){
        customerRepository.save(customer);
    }
}
