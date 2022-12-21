package com.bokkcc.login_demo.runner;

import com.bokkcc.login_demo.model.Customers;
import com.bokkcc.login_demo.model.Products;
import com.bokkcc.login_demo.model.Vendors;
import com.bokkcc.login_demo.repository.CustomersRepository;
import com.bokkcc.login_demo.repository.ProductsRepository;
import com.bokkcc.login_demo.repository.VendorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author : bokkcc
 * @since : 2022.12.21
 */
//@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private final CustomersRepository customersRepository;
    private final VendorsRepository vendorsRepository;
    private final ProductsRepository productsRepository;

//    @Autowired
    public MyCommandLineRunner(CustomersRepository customersRepository, VendorsRepository vendorsRepository, ProductsRepository productsRepository) {
        this.customersRepository = customersRepository;
        this.vendorsRepository = vendorsRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        var customers = List.of(
                new Customers("bokkcc","kaifeng","bokkcc@163.com"),
                new Customers("cy-book","xinyang","cz179@outlook.com")
                );
        var venders = List.of(
                new Vendors("bokkcc","kaifeng"),
                new Vendors("cy-book","xinyang")
        );
        var products = List.of(
                new Products("MacBook Pro 16","computer",1800000L,new Date(),venders.get(0))
        );

        customersRepository.saveAll(customers);
        vendorsRepository.saveAll(venders);
        productsRepository.saveAll(products);
    }
}
