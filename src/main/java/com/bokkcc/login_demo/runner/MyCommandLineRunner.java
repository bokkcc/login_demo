package com.bokkcc.login_demo.runner;

import com.bokkcc.login_demo.model.*;
import com.bokkcc.login_demo.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author : bokkcc
 * @since : 2022.12.21
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private final CustomerDao customerDao;
    private final VendorDao vendorDao;
    private final ProductDao productDao;
    private final UserDao userDao;

    private final RoleDao roleDao;


    @Autowired
    public MyCommandLineRunner(CustomerDao customerDao, VendorDao vendorDao, ProductDao productDao, UserDao userDao, RoleDao roleDao) {
        this.customerDao = customerDao;
        this.vendorDao = vendorDao;
        this.productDao = productDao;
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public void run(String... args) throws Exception {
        var customers = List.of(
                new Customer("bokkcc", "kaifeng", "bokkcc@163.com"),
                new Customer("cy-book", "xinyang", "cz179@outlook.com")
        );
        var vendors = List.of(
                new Vendor("bokkcc", "kaifeng"),
                new Vendor("cy-book", "xinyang")
        );
        var products = List.of(
                new Product("MacBook Pro 16", "computer", 1800000L, new Date(), vendors.get(0))
        );

        var roleAdmin = new Role("ROLE_admin", "管理员");
        var roleUser = new Role("ROLE_user", "用户");
        roleAdmin.setId(1L);
        roleUser.setId(2L);

        if (customerDao.findById(1L).isEmpty()) {
            customerDao.saveAll(customers);
        }
        if (vendorDao.findById(1L).isEmpty()) {
            vendorDao.saveAll(vendors);
        }
        if (productDao.findById(1L).isEmpty()) {
            productDao.saveAll(products);
        }

        if (roleDao.findById(1L).isEmpty()) {
            roleDao.saveAll(List.of(roleAdmin, roleUser));
        }

        var users = List.of(
                new User("bokkcc", "love", true, true, true, true, List.of(roleAdmin, roleUser)),
                new User("cy-book", "love", true, true, true, true, List.of(roleUser))
        );

        if (userDao.findById(1L).isEmpty()) {
            userDao.saveAll(users);
        }


    }
}
