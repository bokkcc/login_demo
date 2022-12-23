package com.bokkcc.login_demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */
@Entity(name="t_order_item")
@Data
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItem;


    private int quantity;

    private Long itemPrice;

    @ManyToOne
    private Product product;

    @ManyToOne
    @Id
    private Order order;
}
