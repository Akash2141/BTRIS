package com.btris.service.user;

import org.springframework.stereotype.Service;

import com.btris.dto.user.CustomerDTO;
import com.btris.dto.user.VendorDTO;
import com.btris.exception.ApplicationErrorCode;
import com.btris.exception.ApplicationException;
import com.btris.exception.UserAlreadyExistsException;
import com.btris.mapper.CustomerMapper;
import com.btris.mapper.VendorMapper;
import com.btris.model.user.Customer;
import com.btris.model.user.Vendor;
import com.btris.repository.user.CustomerRepository;
import com.btris.repository.user.VendorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private VendorRepository vendorRepository;
	private CustomerRepository customerRepository;
	private CustomerMapper customerMapper;
	private VendorMapper vendorMapper;

	public CustomerDTO CustomerLogin(String username, String password)  {
		Customer customer=customerRepository.findByEmailAndPassword(username, password)
				.orElseThrow(()->new ApplicationException(ApplicationErrorCode.NOT_FOUND));
		return customerMapper.toDTO(customer);
	}

	public VendorDTO VendorLogin(String username, String password) {
		Vendor vendor=vendorRepository.findByEmailAndPassword(username, password)
				.orElseThrow(()->new ApplicationException(ApplicationErrorCode.NOT_FOUND));
		
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
