package com.self.SpringJDBCdemo.service;

import com.self.SpringJDBCdemo.dto.LoginRequest;
import com.self.SpringJDBCdemo.dto.LoginResponse;
import com.self.SpringJDBCdemo.model.AuthUser;
import com.self.SpringJDBCdemo.model.User;
import com.self.SpringJDBCdemo.repository.AuthUserRepository;
import com.self.SpringJDBCdemo.repository.UserRepository;
import com.self.SpringJDBCdemo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthUserService {

    @Autowired
    public AuthUserRepository authUserRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    public void registerUser(AuthUser authUser) {
        String role = authUser.getRole() == null ? "" : authUser.getRole().trim().toUpperCase();
        if (role.startsWith("ROLE_")) {
            role = role.substring(5);
        }
        authUser.setRole(role);
        authUserRepository.save(authUser);

        User user = new User();
        user.setId(authUser.getId());              // 🔥 SAME ID
        user.setUsername(authUser.getUsername());
        user.setName(authUser.getUsername());      // or from request
        user.setAge(0);

        userRepository.save(user);
    }

    public LoginResponse login(LoginRequest request) {

        try {
            // authenticationManager internally calls loadUserByUsername()
            // and matches the password using PasswordEncoder
            // At this point user is authenticated only for this request
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            // auth.getPrincipal() returns the authenticated UserDetails object
            // which contains username and roles — NO DB call needed here ✅
            UserDetails userDetails = (UserDetails) auth.getPrincipal();

            // extract roles from authenticated UserDetails
            // getAuthorities() returns ["ROLE_USER", "ROLE_ADMIN"] etc.
            List<String> roles = userDetails.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            // Token contains:
            // username // roles // issuedAt // expiry // signature
            String token = jwtUtil.generateToken(
                    userDetails.getUsername(),  // ✅ username from UserDetails
                    roles                       // ✅ roles from UserDetails
            );

            return new LoginResponse(
                    token,
                    request.getUsername(),
                    "Login successful"
            );

        } catch (AuthenticationException e) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid username or password",
                    e
            );
        }
    }
}
