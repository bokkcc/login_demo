package com.bokkcc.login_demo.service;

import com.bokkcc.login_demo.dao.UserDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author : bokkcc
 * @since : 2022.12.22
 */

@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userDao.findUserByUsername(username);
        if(null == user){
            throw new UsernameNotFoundException("user not found");
        }
        return user;
    }
}
