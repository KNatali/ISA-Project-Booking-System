package com.isa.ISAproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address> findAll(){
		return this.addressRepository.findAll();
	}
	public Optional<Address> findById(Long id) {
		return this.addressRepository.findById(id);
	}
	public Address save(Address newAddress) {
		return this.addressRepository.save(newAddress);
	}

	
	public void delete(Long id) {
		this.addressRepository.deleteById(id);
	}
	

	
}
