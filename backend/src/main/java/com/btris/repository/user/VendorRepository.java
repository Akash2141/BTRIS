package com.btris.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.btris.model.user.Vendor;
import com.google.common.base.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {
	
	Optional<Vendor> findByEmailAndPassword(String email,String password);

}
