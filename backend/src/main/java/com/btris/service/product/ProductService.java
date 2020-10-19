package com.btris.service.product;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.btris.dto.product.ProductDTO;
import com.btris.mapper.ProductMapper;
import com.btris.model.product.Product;
import com.btris.repository.product.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	public void saveProduct(ProductDTO productDTO) {
//		Product product = productDTO._convertToProductEntity();
		productRepository.save(productMapper.toEntity(productDTO));
	}

	public void updateProduct(ProductDTO productDTO) {
//		Product product = productDTO._convertToProductEntity();
		productRepository.save(productMapper.toEntity(productDTO));
	}

	public void deleteProduct(String productId) {
		productRepository.deleteById(productId);
	}

	public void getById(String productId) {
		productRepository.findById(productId);
	}

	public List<ProductDTO> getProducts() {
		List<ProductDTO> productDTOList=productMapper.toDTOList(productRepository.findAll());
		return productDTOList;
	}
}
