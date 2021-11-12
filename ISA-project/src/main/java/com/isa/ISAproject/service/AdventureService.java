package com.isa.ISAproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.repository.AdventureRepository;

@Service
public class AdventureService {
	@Autowired
	private AdventureRepository adventureRepository;
	
	public List<Adventure> findAll(){
		return this.adventureRepository.findAll();
	}

}
