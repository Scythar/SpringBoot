package com.self.SpringJDBCdemo.repository;

import com.self.SpringJDBCdemo.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository take two type parameters
public interface AuthUserRepository extends JpaRepository<AuthUser,Integer> {
//JpaRepository<T, ID> needs both the Entity type and the type of the entity’s primary key (ID).
    //AuthUser primary key is Id, who's data type is Integer


    Optional<AuthUser> findByUsername(String username);
}
