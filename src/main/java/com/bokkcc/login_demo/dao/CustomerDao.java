package com.bokkcc.login_demo.dao;

import com.bokkcc.login_demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */
public interface CustomerDao extends JpaRepository<Customer, Long> {

}
