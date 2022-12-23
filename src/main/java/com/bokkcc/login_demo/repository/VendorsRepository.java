package com.bokkcc.login_demo.repository;

import com.bokkcc.login_demo.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : bokkcc
 * @since : 2022.12.21
 */
public interface VendorsRepository extends JpaRepository<Vendor,Long> {
}
