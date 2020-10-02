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
import com.btris.model.user.Customer;
import com.btris.service.user.UserService;
import com.google.common.base.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/customer/login")
	public Optional<Customer> CustomerLogin(@RequestParam String username,@RequestParam String password) {
		return userService.CustomerLogin(username, password);
	}
	
	@GetMapping("/seller/login")
	public void VendorLogin(@RequestParam String username,@RequestParam String password) {
		
	}
	
	@PostMapping("/customer/register")
	public void CustomerRegister(@RequestBody CustomerDTO customerDTO) {
		userService.CustomerRegister(customerDTO);
	}
	
	@PostMapping("/seller/register")
	public void VendorRegister(@RequestBody VendorDTO vendor) {
		
	}

}
