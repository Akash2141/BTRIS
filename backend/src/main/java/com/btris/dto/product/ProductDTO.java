package com.btris.dto.product;

import java.util.List;

import com.btris.dto.user.VendorDTO;

import lombok.Data;

@Data
public class ProductDTO {
	private String id;
	private String description;
	private int price;
	private String currency;
	private List<VendorDTO> vendorDTOList;
}
