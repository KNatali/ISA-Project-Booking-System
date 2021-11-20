package com.isa.ISAproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.CottageOwner;
import com.isa.ISAproject.repository.CottageOwnerRepository;

@Service
public class CottageOwnerService {
	@Autowired
	private CottageOwnerRepository cottageOwnerRepository;
	public List<CottageOwner> findAll()
	{
		return this.cottageOwnerRepository.findAll();
	}
	public Page<CottageOwner> findAll(Pageable page)
	{
		return cottageOwnerRepository.findAll(page);
	}
	public Optional<CottageOwner> findById(Long id)
	{
		return this.cottageOwnerRepository.findById(id);
	}
	public CottageOwner save(CottageOwner newCottageOwner)
	{
		return this.cottageOwnerRepository.save(newCottageOwner);
	}
	public CottageOwner findByFirstNameAndLastName(String firstName, String lastName) 
	{
		return this.cottageOwnerRepository.findByFirstNameAndLastName(firstName, lastName);
	}
}
