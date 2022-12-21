package com.bokkcc.login_demo.controller;

import com.bokkcc.login_demo.model.Products;
import com.bokkcc.login_demo.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductsRepository productsRepository;
    @GetMapping("/{id}")
    public Products getProductById(@PathVariable("id") Long id){
        return productsRepository.findById(id).orElse(null);
    }
}
