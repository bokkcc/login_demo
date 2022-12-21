package com.bokkcc.login_demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */
@Entity
@Data
@NoArgsConstructor
public class Vendors {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String address;

}
