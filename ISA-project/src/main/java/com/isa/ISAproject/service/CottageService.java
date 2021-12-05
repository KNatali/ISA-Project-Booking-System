package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.repository.AddressRepository;
import com.isa.ISAproject.repository.CottageRepository;

@Component
public class CottageService {
	@Autowired
	private CottageRepository cottageRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	public List<Cottage> findAll() {
		return this.cottageRepository.findAll();
	}
	public Optional<Cottage> getOne(Long id) {
		return this.cottageRepository.findById(id);
	}
	public List<Cottage> findByName(String name) {
		return this.cottageRepository.findByName(name);
	}
	public List<Cottage> findByAddress(String address){
		return this.cottageRepository.findByAddress(address);
	}
	public List<Cottage> sortByName(){
		return this.cottageRepository.findByOrderByName();
	}
	public List<Cottage> sortByGrade(){
		return this.cottageRepository.findByOrderByGradeDesc();
	}
	public List<Cottage> sortByCity(){
		List<Cottage> allCottages=this.cottageRepository.findAll();
		List<Address> allAddressesSortByCities=this.addressRepository.findByOrderByCity();
		List<Cottage> res=new ArrayList<>();
		for (Address address : allAddressesSortByCities) {
			for (Cottage cottage : allCottages) {
				if(cottage.getAddress().getId().equals(address.getId())  ) {
					res.add(cottage);
				}
			}
		}
		return res;
	}
}
