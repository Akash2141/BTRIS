package com.btris.dto.product;

import lombok.Data;

@Data
public class ProductDTO {
	private String id;
	private String description;
	private int price;
	private String currency;
}
