package com.bokkcc.login_demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : bokkcc
 * @since : 2022.12.22
 */
@Entity(name = "t_role")
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name;

    private String nameZh;

    public Role(String name, String nameZh) {
        this.name = name;
        this.nameZh = nameZh;
    }
}
