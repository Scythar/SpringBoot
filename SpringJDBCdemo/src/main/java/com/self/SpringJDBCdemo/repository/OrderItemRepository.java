package com.self.SpringJDBCdemo.repository;

import com.self.SpringJDBCdemo.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {}

