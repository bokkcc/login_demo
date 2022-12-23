package com.bokkcc.login_demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */
@Entity(name = "t_vendor")
@Data
@NoArgsConstructor
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;


    public Vendor(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
