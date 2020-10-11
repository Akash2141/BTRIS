package com.btris.dto.product;

import java.util.List;

import com.btris.model.product.Product;
import com.btris.model.user.Vendor;

import lombok.Data;

@Data
public class ProductDTO {
	private String id;
	private String description;
	private int price;
	private String currency;
	private List<Vendor> vendorList;

	public Product _convertToProductEntity() {
		Product product = new Product();
		product.setId(getId());
		product.setDescription(getDescription());
		product.setPrice(getPrice());
		product.setCurrency(getCurrency());
		product.setVendors(getVendorList());
		return product;
	}

}
