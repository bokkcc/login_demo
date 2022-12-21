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
@Entity
@Table
@Data
@NoArgsConstructor
public class ProductNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String text;
    @CreationTimestamp
    private Date date;

    @ManyToOne
    private Products products;
}
