package com.bokkcc.login_demo.controller;

import com.bokkcc.login_demo.model.Product;
import com.bokkcc.login_demo.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductsRepository productsRepository;
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productsRepository.findById(id).orElse(null);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productsRepository.findAll();
    }
}
