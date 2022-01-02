package com.isa.ISAproject.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Authority;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.service.AuthorityService;

public class InstructorMapper {

	@Autowired
	private static AuthorityService authorityService;

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

				i.getBiography(),

				i.getGrade()

				);
		return instructorDTO;
	}
	

	
}
