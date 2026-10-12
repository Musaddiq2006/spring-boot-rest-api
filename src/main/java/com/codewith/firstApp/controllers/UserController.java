package com.codewith.firstApp.controllers;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codewith.firstApp.model.User;

@RestController 
@RequestMapping("/user")
public class UserController {

   private Map<Integer,User> userDB = new HashMap<>();

    //1) create a dummy DB using hashmaps
    //2)implement postmapping on a function that changes something

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        userDB.putIfAbsent(user.getid(),user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
        
    }

    @PutMapping 
    public ResponseEntity<User> updateUser(@RequestBody User user){
        if(!userDB.containsKey(user.getid()))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        userDB.put(user.getid(),user);
            return ResponseEntity.ok(user);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        if(!userDB.containsKey(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        userDB.remove(id);
        return ResponseEntity.ok("User Deleted");
    }

    @GetMapping
    public List<User> getUser(){
        return new ArrayList<>(userDB.values());
    }

}
