package com.btris.dto.user;

import java.util.Date;

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
	
	public Vendor _toConvertVendorEntity() {
		Vendor vendor=new Vendor();
		vendor.setId(getId());
		vendor.setEmail(getEmail());
		vendor.setFirstName(getFirstName());
		vendor.setLastName(getLastName());
		vendor.setContact(getContact());
		vendor.setHash_password(getHash_password());
		vendor.setPassword(getPassword());
		vendor.setRegisteredAt(getRegisteredAt());
		vendor.setLastLogin(getLastLogin());
		vendor.setActive(isActive());
		vendor.setState(getState());
		return vendor;
	}
}
