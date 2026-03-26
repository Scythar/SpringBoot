package com.self.SpringJDBCdemo.service;

import com.self.SpringJDBCdemo.model.AuthUser;
import com.self.SpringJDBCdemo.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthUserRepository authUserRepository;

    /*
        This method is called internally by authenticationManager.authenticate()
        during login.

        Spring Security calls this to:
        1. Fetch user from DB by username
        2. Build UserDetails object (username + password + roles)
        3. Match password using PasswordEncoder automatically
        4. Return Authentication object if valid

        This is the ONLY place DB is hit during the entire auth flow.
        After login, JWT token carries all info — no DB call needed.
     */
    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {

        // Step 1 — fetch user from DB by username
        // throws UsernameNotFoundException if not found
        AuthUser user = authUserRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User not found with username: " + userName));

        /*
            Step 2 — convert AuthUser entity → Spring Security UserDetails

            User.withUsername() is a Spring Security builder that creates
            a UserDetails object with:
                - username  → used for identification
                - password  → matched against request password by PasswordEncoder
                - roles     → converted to GrantedAuthority internally
                              "USER"  → "ROLE_USER"
                              "ADMIN" → "ROLE_ADMIN"

            NOTE: .roles() automatically prefixes "ROLE_" to whatever you pass
            so store "USER" or "ADMIN" in DB, not "ROLE_USER" or "ROLE_ADMIN"

            If you store "ROLE_USER" in DB → use .authorities() instead of .roles()
            to avoid double prefix "ROLE_ROLE_USER" ❌
         */
        return User.withUsername(user.getUsername())
                .password(user.getPassword())  // already hashed in DB ✅
                .roles(user.getRole())          // "USER" → "ROLE_USER" ✅
                .build();
    }
}