package com.btris.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.btris.model.product.ProductInventory;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory, String> {

}
