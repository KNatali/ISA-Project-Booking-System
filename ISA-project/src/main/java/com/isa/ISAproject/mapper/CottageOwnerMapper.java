package com.isa.ISAproject.mapper;

import com.isa.ISAproject.dto.CottageOwnerProfileDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.model.CottageOwner;
import com.isa.ISAproject.model.Instructor;

public class CottageOwnerMapper {
	public CottageOwnerMapper() {}
	
	public static CottageOwnerProfileDTO convertToDTO(CottageOwner c) {
		CottageOwnerProfileDTO cottageOwnerDTO=new CottageOwnerProfileDTO(
				c.getUsername(),
				c.getPassword(),
				c.getEmail(),
				c.getFirstName(),
				c.getLastName(),
				c.getAddress().getStreet(),
				c.getAddress().getState(),
				c.getAddress().getCity(),
				c.getMobile(),
				c.getId()
				);
		return cottageOwnerDTO;
	}
}
