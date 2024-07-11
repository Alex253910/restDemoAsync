package com.example.async.demo.service;

import com.example.async.demo.dto.Order;
import com.example.async.demo.entity.InventoryEntity;
import com.example.async.demo.entity.OrderEntity;
import com.example.async.demo.repository.InventoryRepository;
import com.example.async.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryRepository inventoryRepository;

    public Boolean SaveOrder(Order order) {
        InventoryEntity inventory = inventoryRepository.findByItemId(order.getItemId());
        if(inventory.getQuantity() < order.getQuantity())
        {
            orderRepository.save(OrderEntity.builder()
                                            .itemId(order.getItemId())
                                            .description(order.getDescription())
                                            .quantity(order.getQuantity())
                                            .build());
            return true;
        }
        return false;
    }
}
