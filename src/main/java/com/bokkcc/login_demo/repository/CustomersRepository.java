package com.bokkcc.login_demo.repository;

import com.bokkcc.login_demo.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */
public interface CustomersRepository extends JpaRepository<Customers, Long> {

}
