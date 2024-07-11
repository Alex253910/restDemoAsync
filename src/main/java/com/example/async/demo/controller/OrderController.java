package com.example.async.demo.controller;

import com.example.async.demo.dto.Order;
import com.example.async.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/OrderService")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, path = "/placeOrder", produces = "application/json")
    public Boolean placeOrder(@RequestBody Order order) {
        return orderService.SaveOrder(order);
    }
}
