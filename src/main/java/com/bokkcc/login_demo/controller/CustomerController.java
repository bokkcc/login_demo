package com.bokkcc.login_demo.controller;

import com.bokkcc.login_demo.model.Customer;
import com.bokkcc.login_demo.repository.CustomersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : bokkcc
 * @since : 2022.12.21
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomersRepository customersRepository;

    public CustomerController(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @GetMapping("/all")
    public List<Customer> findAllCustomer() {
        return customersRepository.findAll();
    }
}
