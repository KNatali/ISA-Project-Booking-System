package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AddressDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.AdventureRepository;

@Service
public class AdventureService {
	@Autowired
	private AdventureRepository adventureRepository;
	
	public List<AdventureDTO> findAll(){
		List<Adventure> adventures= this.adventureRepository.findAll();
		return AdventureMapper.convertoToDTOs(adventures);
		
	}
	public AdventureDTO findById(Long id) {
		Optional<Adventure> adventure=this.adventureRepository.findById(id);
		return AdventureMapper.convertToDTO(adventure.get());
	}

	
	public void delete(Long id) {
		this.adventureRepository.deleteById(id);
	}
	

	public List<Adventure> findByInstructor(Instructor instructor){
		return this.adventureRepository.findByInstructor(instructor);
	}
	

}
