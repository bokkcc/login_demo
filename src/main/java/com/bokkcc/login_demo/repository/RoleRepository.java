package com.bokkcc.login_demo.repository;

import com.bokkcc.login_demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : bokkcc
 * @since : 2022.12.22
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
}
