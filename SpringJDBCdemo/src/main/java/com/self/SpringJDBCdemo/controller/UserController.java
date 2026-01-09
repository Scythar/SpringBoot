package com.self.SpringJDBCdemo.controller;


import com.self.SpringJDBCdemo.dto.*;
import com.self.SpringJDBCdemo.exception.UserNotFoundException;
import com.self.SpringJDBCdemo.security.JwtUtil;
import com.self.SpringJDBCdemo.security.SecurityConfig;
import com.self.SpringJDBCdemo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/user")
    public List<UserResponseDTO> getAllUser(){
        return userService.fetchAllUser();
    }

    @GetMapping("/user/{id}")
    public UserResponseDTO getUserByID(@PathVariable int id){

        return userService.findUserById(id);
    }

    @PostMapping("/user")
    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO data) throws UserNotFoundException {
        return userService.createUser(data);
    }

    @PutMapping("/user/{id}")
    public UserResponseDTO updateUser(@Valid @RequestBody UserRequestDTO data, @PathVariable int id){
        //{
        //  "name": "Nitesh",
        //  "age": 25
        //}

        //Spring Boot automatically converts it to:
        //
        //UserRequestDTO data = new UserRequestDTO();
        //data.setName("Nitesh");
        //data.setAge(25);
        return userService.updateUser(id,data);
    }

    @DeleteMapping("/user/{id}")
    public UserResponseDTO deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }


    @GetMapping("/users/search")
    public UserResponseDTO searchUser(@Valid @RequestParam(name = "name") String name){
        return userService.searchUser(name);
    }


    @GetMapping("/users/searchNameContaining")
    public UserResponseDTO searchUserName(@Valid @RequestParam(name = "name") String name){
        return userService.searchUserContainingName(name);
    }

    @GetMapping("users/searchByAge")
    public List<UserResponseDTO> searchbyAgeBetween(@Valid @RequestParam int minAge, @Valid @RequestParam int maxAge){
        return userService.findByAgeBetween(minAge,maxAge);
    }

    @GetMapping("/users/searchAboveAge")
    public List<UserResponseDTO> searchAboveAge(@Valid @RequestParam(name = "age") int ageLimit){
        return userService.ageGreaterThan(ageLimit);
    }




}
