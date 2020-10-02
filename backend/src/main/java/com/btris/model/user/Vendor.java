package com.btris.model.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;

import com.btris.dto.user.VendorDTO;

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
	
	public VendorDTO _toConvertVendorDTO() {
		VendorDTO vendorDTO=new VendorDTO();
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
		return vendorDTO;
	}

}
