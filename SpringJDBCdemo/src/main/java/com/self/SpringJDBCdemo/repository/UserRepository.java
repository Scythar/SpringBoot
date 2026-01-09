package com.self.SpringJDBCdemo.repository;

import com.self.SpringJDBCdemo.model.User;
import com.self.SpringJDBCdemo.projection.UserNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByName(String name);      //if multiple user exists with the same name, API will give 500 error

    Optional<User> findByUsername(String username);

    List<User> findByAgeGreaterThan(int age);

    List<User> findByAgeBetween(int start, int end);

    Optional<User> findByNameContaining(String text);    //if multiple user exists with the same name, API will give 500 error

    //JPQL(java persistent or Hibernate query language), which looks like SQL, but:
    //✔ uses entity names (User) instead of table name 'users'
    //✔ uses entity fields (age) instead of column name 'age'
    //✔ Hibernate converts it into SQL for your database
    @Query("SELECT u FROM User u WHERE u.age < :age")
    List<User> getUsersAboveAge(@Param("age") int age);


    //nativeQuery = true means:
    //Spring Data JPA will run the SQL query EXACTLY as you wrote it — as a raw SQL query, NOT as JPQL (Hibernate query language).
    @Query(value = "select * from users where age > :age", nativeQuery = true)
    List<User> ageGreaterThan(@Param("age") int age);


    //Projection (VERY IMPORTANT)
    //Instead of returning whole entity, return only required fields.
    //Example: Return only id + name:
    @Query("SELECT u.id AS id, u.name AS name FROM User u")
    List<UserNameProjection> getUserNames();


}