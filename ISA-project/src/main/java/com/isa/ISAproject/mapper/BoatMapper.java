package com.isa.ISAproject.mapper;

import java.util.ArrayList;
import java.util.List;

import com.isa.ISAproject.dto.AddressDTO;
import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.BoatOwnerProfileDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.dto.CottageOwnerProfileDTO;
import com.isa.ISAproject.model.Boat;

public class BoatMapper {
	public BoatMapper() {}
	public static BoatDTO convertToDTO(Boat b) {
		AddressDTO addressDTO=AddressMapper.convertToDTO(b.getAddress());
		BoatOwnerProfileDTO boatOwnerDTO=BoatOwnerMapper.convertToDTO(b.getOwner());
		BoatDTO boatDTO=new BoatDTO(
				b.getId(),
				b.getName(),
				addressDTO,
				b.getDescription(),
				b.getGrade(),
				b.getPrice(),
				boatOwnerDTO,
				b.getMainPicture(),
				b.getMaxPersons(),
				b.getCancellationPercentage()
				);
		return boatDTO;
				
	}
	
	public static List<BoatDTO> convertoToDTOs(List<Boat> boats){
		List<BoatDTO> boatsDTO=new ArrayList<>();
		for (Boat b : boats) {
			BoatDTO dto=convertToDTO(b);
			boatsDTO.add(dto);
		}
		return boatsDTO;
	}
}
