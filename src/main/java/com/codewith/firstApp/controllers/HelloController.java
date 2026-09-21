package com.codewith.firstApp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }
    @GetMapping("/yo")
    public int lol(){
        return 123;
    }
    
}