package com.bokkcc.login_demo.repository;

import com.bokkcc.login_demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */

public interface ProductsRepository extends JpaRepository<Product, Long> {

}
