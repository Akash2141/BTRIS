package com.btris.dto.user;

import java.util.Date;

import com.btris.model.user.Customer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO {
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
	
	public Customer _toConvertCustomerEntity() {
		Customer customer=new Customer();
		customer.setId(getId());
		customer.setFirstName(getFirstName());
		customer.setLastName(getLastName());
		customer.setEmail(getEmail());
		customer.setPassword(getPassword());
		customer.setHash_password(getHash_password());
		customer.setContact(getContact());
		customer.setRegisteredAt(getRegisteredAt());
		customer.setLastLogin(getLastLogin());
		customer.setActive(isActive());
		customer.setState(getState());
		return customer;
	}
	
}
