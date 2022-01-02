package com.isa.ISAproject.mapper;



import com.isa.ISAproject.dto.AddressDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.model.Adventure;

import java.util.ArrayList;
import java.util.List;

public class AdventureMapper {

	public AdventureMapper() {}
	
	public static AdventureDTO convertToDTO(Adventure a) {
		AddressDTO addressDTO=AddressMapper.convertToDTO(a.getAddress());
		InstructorProfileDTO instructorDTO=InstructorMapper.convertToDTO(a.getInstructor());
		AdventureDTO adventureDTO=new AdventureDTO(
				a.getId(),
				a.getName(),
				addressDTO,
				a.getDescription(),
				a.getAverageGrade(),
				a.getPrice(),
				instructorDTO,
				a.getMainPicture(),
				a.getMaxPersons(),
				a.getCancellationPercentage()
				);
		return adventureDTO;
				
	}
	
	
	
	public static List<AdventureDTO> convertoToDTOs(List<Adventure> adventures){
		List<AdventureDTO> adventuresDTO=new ArrayList<>();
		for (Adventure a : adventures) {
			AdventureDTO dto=convertToDTO(a);
			adventuresDTO.add(dto);
			
		}
		
		return adventuresDTO;
	}
	
}
