package com.example.async.demo.service;

import com.example.async.demo.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    public Flux<ProductResponse> findProduct(int id) {
        if(id  == 2)
        {
            return Flux.just(ProductResponse.builder()
                            .id(2)
                            .product_name("Product for test example")
                            .build())
                    .delayElements(Duration.ofSeconds(1));
        }else{
            return Flux.just(ProductResponse.builder()
                            .id(0)
                            .product_name("Product not found")
                            .build())
                    .delayElements(Duration.ofSeconds(1));
        }
    }
}
