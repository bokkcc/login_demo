package com.bokkcc.login_demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */
@Entity
@Data
@NoArgsConstructor
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderItem;


    private int quantity;

    private Long itemPrice;

    @ManyToOne
    private Products products;

    @ManyToOne
    @Id
    private Orders orders;
}
