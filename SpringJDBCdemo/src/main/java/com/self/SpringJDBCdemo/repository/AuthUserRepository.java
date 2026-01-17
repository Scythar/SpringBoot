package com.self.SpringJDBCdemo.repository;

import com.self.SpringJDBCdemo.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository take two type parameters
public interface AuthUserRepository extends JpaRepository<AuthUser,Integer> {
//JpaRepository<T, ID> needs both the Entity type and the datatype of the entity’s primary key (ID).
    //AuthUser primary key is Id, who's data type is Integer


    //here method naming is important because Spring Data JPA auto-generates the implementation at runtime
    /*  find  → SELECT
        By    → WHERE
        Username -> AuthUser.username

        // final = select * from location where username = ?
     */
    // although AuthUser.username but method name convention is camelcase so findByUsername
    Optional<AuthUser> findByUsername(String username);
}
