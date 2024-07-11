package com.example.async.demo.repository;

import com.example.async.demo.dto.Order;
import com.example.async.demo.entity.OrderEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
    List<OrderEntity> findAll();
}
