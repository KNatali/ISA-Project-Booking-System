package com.isa.ISAproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.repository.CottageRepository;

@Component
public class CottageService {
	@Autowired
	private CottageRepository cottageRepository;
	
	public List<Cottage> findAll() {
		return this.cottageRepository.findAll();
	}
}
