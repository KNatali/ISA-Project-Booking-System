package com.isa.ISAproject.mapper;

import com.isa.ISAproject.dto.AddressDTO;
import com.isa.ISAproject.model.Address;

public class AddressMapper {
	public AddressMapper() {
		
	}
	public static AddressDTO convertToDTO(Address a) {
		AddressDTO addressDTO=new AddressDTO(
				a.getId(),
				a.getStreet(),
				a.getState(),
				a.getCity(),
				a.getLatitude(),
				a.getLongitude()
				);
		return addressDTO;
	}
	
	public static Address convertFromDTO(AddressDTO dto) {
		Address address=new Address(
				dto.getId(),dto.getStreet(),dto.getCity(),dto.getState(),dto.getLatitude(),dto.getLongitude());
		return address;
	}
	


}
