package com.btris.controller.product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btris.dto.product.ProductDTO;

@RestController
public class ProductController {

	@PostMapping
	public void saveProduct(@RequestBody ProductDTO productDTO) {
		
	}
	
	@PutMapping
	public void updateProduct(@RequestBody ProductDTO productDTO) {
		
	}
	
	@DeleteMapping
	public void deleteProduct(@RequestParam String productId ) {
		
	}
	
	@GetMapping
	public void getAllProduct() {
		
	}
	
	@GetMapping
	public void getProductById(@RequestParam String productId) {
		
	}
	
}
