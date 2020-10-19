package com.btris.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.btris.dto.user.CustomerDTO;
import com.btris.dto.user.VendorDTO;
import com.btris.exception.UserAlreadyExistsException;
import com.btris.exception.UserNotFoundException;
import com.btris.mapper.CustomerMapper;
import com.btris.mapper.VendorMapper;
import com.btris.model.user.Customer;
import com.btris.model.user.Vendor;
import com.btris.repository.user.CustomerRepository;
import com.btris.repository.user.VendorRepository;
import com.google.common.base.Optional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private VendorRepository vendorRepository;
	private CustomerRepository customerRepository;
	private CustomerMapper customerMapper;
	private VendorMapper vendorMapper;

	public CustomerDTO CustomerLogin(String username, String password) throws UserNotFoundException {
		Customer customer=customerRepository.findByEmailAndPassword(username, password);
		if(ObjectUtils.isEmpty(customer)) {
			throw new UserNotFoundException("Customer not found");
		}
		return customerMapper.toDTO(customer);
	}

	public VendorDTO VendorLogin(String username, String password) throws UserNotFoundException {
		Vendor vendor=vendorRepository.findByEmailAndPassword(username, password);
		if(vendor==null) {
			throw new UserNotFoundException("Vendor Not Found");
		}
		return vendorMapper.toDTO(vendor);
	}

	public void CustomerRegister(CustomerDTO customerDTO) throws UserAlreadyExistsException {
		Customer customer = customerMapper.toEntity(customerDTO);
		try {
			customerRepository.save(customer);
		}catch(Exception e) {
			throw new UserAlreadyExistsException("Email Id is already exists for the customer.");
		}
	}

	public void VendorRegister(VendorDTO vendorDTO) throws UserAlreadyExistsException {
		Vendor vendor = vendorMapper.toEntity(vendorDTO);
		try {
			vendorRepository.save(vendor);
		}catch(Exception e) {
			throw new UserAlreadyExistsException("Email Id is already exists for the vendor.");
		}
	}

}
