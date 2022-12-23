package com.bokkcc.login_demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */
@Entity(name = "t_product_note")
@Table
@Data
@NoArgsConstructor
public class ProductNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    @CreationTimestamp
    private Date date;

    @ManyToOne
    private Product product;
}
