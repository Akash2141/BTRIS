package com.btris.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btris.model.user.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	Optional<Customer> findByEmailAndPassword(String email,String password);

}
