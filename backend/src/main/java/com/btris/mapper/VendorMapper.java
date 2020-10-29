package com.btris.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.btris.dto.user.VendorDTO;
import com.btris.model.user.Vendor;

@Mapper(componentModel = "spring")
public interface VendorMapper {

	public VendorDTO toDTO(Vendor vendor);
	public Vendor toEntity(VendorDTO vendorDTO);
	public List<Vendor> toEntityList(List<VendorDTO> vendorDTOList);
	public List<VendorDTO> toDTOList(List<Vendor> vendorList);
}
