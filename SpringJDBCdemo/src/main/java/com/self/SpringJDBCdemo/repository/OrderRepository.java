package com.self.SpringJDBCdemo.repository;

import com.self.SpringJDBCdemo.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    Page<Order> findByUser_Id(int userId, Pageable pageable);
    Page<Order> findByUser_Username(String username, Pageable pageable);
}
