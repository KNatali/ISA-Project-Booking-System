package com.isa.ISAproject.mapper;

import com.isa.ISAproject.dto.BoatOwnerProfileDTO;
import com.isa.ISAproject.dto.CottageOwnerProfileDTO;
import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.model.CottageOwner;

public class BoatOwnerMapper {
public BoatOwnerMapper() {}
	
	public static BoatOwnerProfileDTO convertToDTO(BoatOwner b) {
		BoatOwnerProfileDTO boatOwnerDTO=new BoatOwnerProfileDTO(
				b.getUsername(),
				b.getPassword(),
				b.getEmail(),
				b.getFirstName(),
				b.getLastName(),
				b.getAddress().getStreet(),
				b.getAddress().getState(),
				b.getAddress().getCity(),
				b.getMobile(),
				b.getId(),
				b.getGrade()
				);
		return boatOwnerDTO;
	}
}
