package com.btris.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btris.model.user.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	Customer findByEmailAndPassword(String email,String password);

}
