package com.bokkcc.login_demo.dao;

import com.bokkcc.login_demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : bokkcc
 * @since : 2022.12.22
 */
public interface RoleDao extends JpaRepository<Role,Long> {
}
