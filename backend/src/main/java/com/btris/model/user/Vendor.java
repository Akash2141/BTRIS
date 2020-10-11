package com.btris.model.user;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.btris.dto.user.VendorDTO;
import com.btris.model.product.Product;

import lombok.Data;

@Data
@Entity
public class Vendor {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
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
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "vendor_product", joinColumns = { @JoinColumn(name = "vendor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "product_id") })
	private List<Product> products;

	public VendorDTO _toConvertVendorDTO() {
		VendorDTO vendorDTO = new VendorDTO();
		vendorDTO.setId(getId());
		vendorDTO.setEmail(getEmail());
		vendorDTO.setFirstName(getFirstName());
		vendorDTO.setLastName(getLastName());
		vendorDTO.setContact(getContact());
		vendorDTO.setHash_password(getHash_password());
		vendorDTO.setPassword(getPassword());
		vendorDTO.setRegisteredAt(getRegisteredAt());
		vendorDTO.setLastLogin(getLastLogin());
		vendorDTO.setActive(isActive());
		vendorDTO.setState(getState());
		vendorDTO.setProductList(getProducts());
		return vendorDTO;
	}

}
