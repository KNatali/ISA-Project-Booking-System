package com.isa.ISAproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.AdventureRepository;

@Service
public class AdventureService {
	@Autowired
	private AdventureRepository adventureRepository;
	
	public List<Adventure> findAll(){
		return this.adventureRepository.findAll();
	}
	public Optional<Adventure> getOne(Long id) {
		return this.adventureRepository.findById(id);
	}
	public List<Adventure> findByInstructor(Instructor instructor){
		return this.adventureRepository.findByInstructor(instructor);
	}
}
