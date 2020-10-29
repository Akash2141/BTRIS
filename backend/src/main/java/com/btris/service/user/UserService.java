package com.btris.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.btris.dto.user.CustomerDTO;
import com.btris.dto.user.VendorDTO;
import com.btris.exception.UserAlreadyExistsException;
import com.btris.exception.UserNotFoundException;
import com.btris.model.user.Customer;
import com.btris.model.user.Vendor;
import com.btris.repository.user.CustomerRepository;
import com.btris.repository.user.VendorRepository;
import com.google.common.base.Optional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	@Autowired
	VendorRepository vendorRepository;

	@Autowired
	CustomerRepository customerRepository;

	public CustomerDTO CustomerLogin(String username, String password) throws Exception {
		log.info("This is the password::", password);
		Customer customer = customerRepository.findByEmail(username);
		if (customer == null) {
			throw new UserNotFoundException("Customer not found");
		}
		if (!bcryptPasswordEncoder.matches(password, customer.getPassword())) {
			throw new Exception("Password is incorrect");
		}
		return customer._toConvertCustomerDTO();
	}

	public VendorDTO VendorLogin(String username, String password) throws UserNotFoundException {
		Vendor vendor = vendorRepository.findByEmailAndPassword(username, password);
		if (vendor == null) {
			throw new UserNotFoundException("Vendor Not Found");
		}
		return vendor._toConvertVendorDTO();
	}

	public void CustomerRegister(CustomerDTO customerDTO) throws UserAlreadyExistsException {
		Customer customer = customerDTO._toConvertCustomerEntity();
		try {
			customerRepository.save(customer);
		} catch (Exception e) {
			throw new UserAlreadyExistsException("Email Id is already exists for the customer.");
		}
	}

	public void VendorRegister(VendorDTO vendorDTO) throws UserAlreadyExistsException {
		Vendor vendor = vendorDTO._toConvertVendorEntity();
		try {
			vendorRepository.save(vendor);
		} catch (Exception e) {
			throw new UserAlreadyExistsException("Email Id is already exists for the vendor.");
		}
	}

}
