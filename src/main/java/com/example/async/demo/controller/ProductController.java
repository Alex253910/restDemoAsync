package com.example.async.demo.controller;

import com.example.async.demo.dto.ProductResponse;
import com.example.async.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Flux<ProductResponse> findProduct(@PathVariable("id") int id) {
        return productService.findProduct(id);
    }

}
