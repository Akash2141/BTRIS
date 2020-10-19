package com.btris.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btris.model.product.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
