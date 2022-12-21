package com.bokkcc.login_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */
@Entity
@Data
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long num;

    private Long custId;

    private Date date;

}
