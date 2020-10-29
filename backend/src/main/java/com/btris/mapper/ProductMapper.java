package com.btris.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.btris.dto.product.ProductDTO;
import com.btris.model.product.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	public ProductDTO toDTO(Product product);
	public Product toEntity(ProductDTO productDTO);
	public List<ProductDTO> toDTOList(List<Product> productList);
	public List<Product> toEntityList(List<ProductDTO> productDTOList);
}
