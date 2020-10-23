package com.btris.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btris.dto.user.CustomerDTO;
import com.btris.dto.user.VendorDTO;
import com.btris.exception.UserAlreadyExistsException;
import com.btris.service.user.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Autowired
	private UserService userService;

	@GetMapping("/customer/login")
	public CustomerDTO CustomerLogin(@RequestParam String username, @RequestParam String password) {
		password = bcryptPasswordEncoder.encode(password);
		return userService.CustomerLogin(username, password);
	}

	@GetMapping("/seller/login")
	public VendorDTO VendorLogin(@RequestParam String username, @RequestParam String password)  {
		password = bcryptPasswordEncoder.encode(password);
		return userService.VendorLogin(username, password);
	}

	@PostMapping("/customer/register")
	public void CustomerRegister(@RequestBody CustomerDTO customerDTO) throws UserAlreadyExistsException {
		customerDTO.setPassword(bcryptPasswordEncoder.encode(customerDTO.getPassword()));
		userService.CustomerRegister(customerDTO);
	}

	@PostMapping("/seller/register")
	public void VendorRegister(@RequestBody VendorDTO vendorDTO) throws UserAlreadyExistsException {
		vendorDTO.setPassword(bcryptPasswordEncoder.encode(vendorDTO.getPassword()));
		userService.VendorRegister(vendorDTO);
	}

}
