package com.isa.ISAproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.repository.BoatRepository;

@Component
public class BoatService {
	@Autowired
	private BoatRepository boatRepository;
	
	public List<Boat> findAll(){
		return this.boatRepository.findAll();
	}
	public Optional<Boat> getOne(Long id) {
		return this.boatRepository.findById(id);
	}
}
