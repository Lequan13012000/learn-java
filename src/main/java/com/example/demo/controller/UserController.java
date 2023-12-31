package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getListUser(){
        List<UserDto> users = userService.getListUser();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/search")
    public  ResponseEntity<?> searchUser(@RequestParam(name = "keyword",required = false,defaultValue = "") String name){
        List<UserDto> users = userService.searchUser(name);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getUserById(@PathVariable int id){
        UserDto result = userService.getUserById(id);
        return ResponseEntity.ok(result);
    }
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.status(201).body(userService.updateUser(id, user));
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
