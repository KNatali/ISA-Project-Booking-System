package com.isa.ISAproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.repository.CottageRepository;

@Component
public class CottageService {
	@Autowired
	private CottageRepository cottageRepository;
	
	public List<Cottage> findAll() {
		return this.cottageRepository.findAll();
	}
	public Optional<Cottage> getOne(Long id) {
		return this.cottageRepository.findById(id);
	}
	public List<Cottage> findByName(String name) {
		return this.cottageRepository.findByName(name);
	}
}
