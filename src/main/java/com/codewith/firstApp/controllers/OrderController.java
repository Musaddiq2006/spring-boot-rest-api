package com.codewith.firstApp.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class OrderController {
    @GetMapping("/order")
        public String order(@RequestParam String item){
        return "Your order is "+ item; 
    }
    
    
}
