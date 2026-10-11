package com.codewith.firstApp.apps;

import java.util.HashMap;
import java.util.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/user")
public class UserController {

   private Map<Integer,User> userDB = new HashMap<>();

    //1) create a dummy DB using hashmaps
    //2)implement postmapping on a function that changes something

    @PostMapping
    public String createUser(@RequestBody User user){
        userDB.putIfAbsent(user.getid(),user);
        return "User registered";
    }

    @PutMapping 
    public String updateUser(@RequestBody User user){
        if(userDB.containsKey(user.getid()))
            userDB.put(user.getid(),user);
        return "User Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
            userDB.remove(id);
            return "User deleted";
    }

    @GetMapping
    public List<User> getUser(){
        return new ArrayList<>(userDB.values());
    }

}
