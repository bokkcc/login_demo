package com.bokkcc.login_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : bokkcc
 * @since : 2022.12.20
 */
@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String home(){
        return "hOMe";
    }
}
