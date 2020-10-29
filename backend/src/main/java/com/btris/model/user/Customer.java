package com.btris.model.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.btris.dto.user.CustomerDTO;

import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	private String firstName;
	private String lastName;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	private String hash_password;
	private long contact;
	private Date registeredAt;
	private Date lastLogin;
	private boolean isActive;
	private String state;

	public CustomerDTO _toConvertCustomerDTO() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(getId());
		customerDTO.setFirstName(getFirstName());
		customerDTO.setLastName(getLastName());
		customerDTO.setEmail(getEmail());
		customerDTO.setPassword(getPassword());
		customerDTO.setHash_password(getHash_password());
		customerDTO.setContact(getContact());
		customerDTO.setRegisteredAt(getRegisteredAt());
		customerDTO.setLastLogin(getLastLogin());
		customerDTO.setActive(isActive());
		customerDTO.setState(getState());
		return customerDTO;
	}
}
