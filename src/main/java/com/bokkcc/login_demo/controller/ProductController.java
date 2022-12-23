package com.bokkcc.login_demo.controller;

import com.bokkcc.login_demo.model.Product;
import com.bokkcc.login_demo.dao.ProductDao;
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
    private ProductDao productDao;
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productDao.findById(id).orElse(null);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productDao.findAll();
    }
}
