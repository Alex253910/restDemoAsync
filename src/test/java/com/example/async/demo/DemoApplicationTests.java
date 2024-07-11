package com.example.async.demo;

import com.example.async.demo.controller.ProductController;
import com.example.async.demo.dto.ProductResponse;
import com.example.async.demo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@SpringBootTest
class DemoApplicationTests {

	@Mock
	private ProductService productService;

	@InjectMocks
	private ProductController itemController;

	private WebTestClient webTestClient;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		webTestClient = WebTestClient.bindToController(itemController).build();
	}

	@Test
	public void testProductItem() {
		// Mock del servicio para devolver una lista de elementos
		when(productService.findProduct(2)).thenReturn(Flux.just(ProductResponse.builder()
				.id(2)
				.product_name("Product for test example")
				.build()));

		// Realizar una solicitud GET al endpoint y verificar la respuesta
		webTestClient.get().uri("/products/2")
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(String.class)
				.hasSize(3)
				.contains();
	}

}
