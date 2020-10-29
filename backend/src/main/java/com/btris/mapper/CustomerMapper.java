package com.btris.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.btris.dto.user.CustomerDTO;
import com.btris.model.user.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	
	public CustomerDTO toDTO(Customer customer);
	public Customer toEntity(CustomerDTO customerDTO);
	public List<CustomerDTO> toDTOList(List<Customer> customerList);
	public List<Customer> toEntityList(List<CustomerDTO> customerDTOList);

}
