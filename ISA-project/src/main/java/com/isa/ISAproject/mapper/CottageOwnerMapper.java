package com.isa.ISAproject.mapper;

import com.isa.ISAproject.dto.CottageOwnerProfileDTO;
import com.isa.ISAproject.model.CottageOwner;

public class CottageOwnerMapper {
	
	public CottageOwnerMapper() {}
	
	public static CottageOwnerProfileDTO convertToDTO(CottageOwner co) {
		CottageOwnerProfileDTO cottageOwnerDTO=new CottageOwnerProfileDTO(
				co.getUsername(),
				co.getPassword(),
				co.getEmail(),
				co.getFirstName(),
				co.getLastName(),
				co.getAddress().getStreet(),
				co.getAddress().getState(),
				co.getAddress().getCity(),
				co.getMobile(),
				co.getId(),
				co.getRole()
				//co.getBiography(),
				//co.getGrade()
				);
		return cottageOwnerDTO;
	}
}
