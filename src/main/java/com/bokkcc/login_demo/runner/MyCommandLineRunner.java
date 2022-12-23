package com.bokkcc.login_demo.runner;

import com.bokkcc.login_demo.model.*;
import com.bokkcc.login_demo.repository.*;
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
    private final CustomersRepository customersRepository;
    private final VendorsRepository vendorsRepository;
    private final ProductsRepository productsRepository;
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;


    @Autowired
    public MyCommandLineRunner(CustomersRepository customersRepository, VendorsRepository vendorsRepository, ProductsRepository productsRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.customersRepository = customersRepository;
        this.vendorsRepository = vendorsRepository;
        this.productsRepository = productsRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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

        if (customersRepository.findById(1L).isEmpty()) {
            customersRepository.saveAll(customers);
        }
        if (vendorsRepository.findById(1L).isEmpty()) {
            vendorsRepository.saveAll(vendors);
        }
        if (productsRepository.findById(1L).isEmpty()) {
            productsRepository.saveAll(products);
        }

        if (roleRepository.findById(1L).isEmpty()) {
            roleRepository.saveAll(List.of(roleAdmin, roleUser));
        }

        var users = List.of(
                new User("bokkcc", "love", true, true, true, true, List.of(roleAdmin, roleUser)),
                new User("cy-book", "love", true, true, true, true, List.of(roleUser))
        );

        if (userRepository.findById(1L).isEmpty()) {
            userRepository.saveAll(users);
        }


    }
}
