package com.btris.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btris.dto.user.CustomerDTO;
import com.btris.dto.user.VendorDTO;
import com.btris.model.user.Customer;
import com.btris.model.user.Vendor;
import com.btris.repository.user.CustomerRepository;
import com.btris.repository.user.VendorRepository;
import com.google.common.base.Optional;

@Service
public class UserService {

	@Autowired
	VendorRepository vendorRepository;

	@Autowired
	CustomerRepository customerRepository;

	public Optional<Customer> CustomerLogin(String username, String password) {
		return customerRepository.findByEmailAndPassword(username, password);
	}

	public void VendorLogin(String username, String password) {
		vendorRepository.findByEmailAndPassword(username, password);
	}

	public void CustomerRegister(CustomerDTO customerDTO) {
		Customer customer = customerDTO._toConvertCustomerEntity();
		customerRepository.save(customer);
	}

	public void VendorRegister(VendorDTO vendorDTO) {
		Vendor vendor = vendorDTO._toConvertVendorEntity();
		vendorRepository.save(vendor);
	}

}
