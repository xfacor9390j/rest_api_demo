package com.abhinay.restapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class DemoRestController {
    @GetMapping("/hello")
    public String gretting(){
        return"hello world";
    }
}
