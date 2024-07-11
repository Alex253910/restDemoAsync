package com.example.async.demo.repository;

import com.example.async.demo.entity.InventoryEntity;
import com.example.async.demo.entity.OrderEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {
    InventoryEntity findByItemId(int itemId);
}
