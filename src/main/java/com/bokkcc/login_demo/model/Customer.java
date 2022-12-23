package com.bokkcc.login_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */
@Entity(name="t_customer")
@Data
@NoArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String email;


    public Customer(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }
}
