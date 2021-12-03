package com.isa.ISAproject.mapper;

import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.model.Instructor;

public class InstructorMapper {

	public InstructorMapper() {}
	
	public static InstructorProfileDTO convertToDTO(Instructor i) {
		InstructorProfileDTO instructorDTO=new InstructorProfileDTO(
				i.getUsername(),
				i.getPassword(),
				i.getEmail(),
				i.getFirstName(),
				i.getLastName(),
				i.getAddress().getStreet(),
				i.getAddress().getState(),
				i.getAddress().getCity(),
				i.getMobile(),
				i.getId(),
				i.getRole(),
				i.getBiography()
				);
		return instructorDTO;
	}
}
