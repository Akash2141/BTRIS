package com.btris.dto.user;

import java.util.Date;
import java.util.List;

import com.btris.model.product.Product;
import com.btris.model.user.Vendor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VendorDTO {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String hash_password;
	private long contact;
	private Date registeredAt;
	private Date lastLogin;
	private boolean isActive;
	private String state;
	private List<Product> products;
}
