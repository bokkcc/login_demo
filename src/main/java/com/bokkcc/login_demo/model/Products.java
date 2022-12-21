package com.bokkcc.login_demo.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private Long price;
    @CreationTimestamp
    private Date shelfLife;

    @ManyToOne
    private Vendors vendors;

    public Products(String name, String description, Long price, Date shelfLife, Vendors vendors) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.shelfLife = shelfLife;
        this.vendors = vendors;
    }
}
