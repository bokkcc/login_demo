package com.bokkcc.login_demo.controller;

import com.bokkcc.login_demo.model.Vendor;
import com.bokkcc.login_demo.repository.VendorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : bokkcc
 * @since : 2022.12.21
 */
@RestController
@RequestMapping("/vendors")
public class VendorsController {

    private final VendorsRepository vendorsRepository;

    @Autowired
    public VendorsController(VendorsRepository vendorsRepository) {
        this.vendorsRepository = vendorsRepository;
    }

    @GetMapping("/all")
    public List<Vendor> getAllVendors(){
        return vendorsRepository.findAll();
    }
}
