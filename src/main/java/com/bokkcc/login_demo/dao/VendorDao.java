package com.bokkcc.login_demo.dao;

import com.bokkcc.login_demo.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : bokkcc
 * @since : 2022.12.21
 */
public interface VendorDao extends JpaRepository<Vendor,Long> {
}
