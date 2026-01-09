package com.self.SpringJDBCdemo.controller;


import com.self.SpringJDBCdemo.dto.LoginRequest;
import com.self.SpringJDBCdemo.dto.LoginResponse;
import com.self.SpringJDBCdemo.model.AuthUser;
import com.self.SpringJDBCdemo.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {




    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthUserService authService;



    //In Spring, every request firstly goes into jwtFilter and sees whether I have to filter it according to 'ShouldNotFilter' method
    // If skipped then request comes and authentication happens in controller class,
    @PostMapping("/auth/register")
    public String register(@RequestBody AuthUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        authService.registerUser(user);

        return "User registered successfully";

    }

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
