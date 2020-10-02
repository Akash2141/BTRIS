package com.btris.dto.product;

import com.btris.model.product.Product;

import lombok.Data;

@Data
public class ProductDTO {
	private String id;
	private String description;
	private int price;
	private String currency;

	public Product _convertToProductEntity() {
		Product product = new Product();
		product.setId(getId());
		product.setDescription(getDescription());
		product.setPrice(getPrice());
		product.setCurrency(getCurrency());
		return product;
	}

}
