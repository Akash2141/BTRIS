package com.btris.controller.product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btris.dto.product.ProductDTO;
import com.btris.service.product.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	@PostMapping("/add")
	public void saveProduct(@RequestBody ProductDTO productDTO) {
		productService.saveProduct(productDTO);
	}

	@PutMapping("/update")
	public void updateProduct(@RequestBody ProductDTO productDTO) {
		productService.updateProduct(productDTO);
	}

	@DeleteMapping("/delete")
	public void deleteProduct(@RequestParam String productId) {
		productService.deleteProduct(productId);
	}

	@GetMapping("/all")
	public void getProducts() {
		productService.getProducts();
	}

	@GetMapping("/{id}")
	public void getProductById(@RequestParam String id) {
		productService.getById(id);
	}

}
