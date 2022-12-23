package com.bokkcc.login_demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */

@Entity(name = "t_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Long price;
    @CreationTimestamp
    private Date shelfLife;

    @ManyToOne
    private Vendor vendors;

    public Product(String name, String description, Long price, Date shelfLife, Vendor vendors) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.shelfLife = shelfLife;
        this.vendors = vendors;
    }
}
