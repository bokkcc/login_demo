package com.bokkcc.login_demo.dao;

import com.bokkcc.login_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : bokkcc
 * @since : 2022.12.22
 */
public interface UserDao extends JpaRepository<User,Long> {
    /**
     * 通过用户名查找用户
     * @param username 用户名
     * @return 用户
     */
    User findUserByUsername(String username);
}
