package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.repository.AdditionalItemRepository;
import com.isa.ISAproject.repository.AddressRepository;
import com.isa.ISAproject.repository.BoatRepository;

@Component
public class BoatService {
	@Autowired
	private BoatRepository boatRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private AdditionalItemRepository additionalItemRepository;
	
	public List<Boat> findAll(){
		return this.boatRepository.findAll();
	}
	public Optional<Boat> getOne(Long id) {
		return this.boatRepository.findById(id);
	}
	public List<Boat> findByMotorNumber(int motorNumber){
		return this.boatRepository.findByMotorNumber(motorNumber);
	}
	public List<Boat> findByMotorPower(double motorPower){
		return this.boatRepository.findByMotorPower(motorPower);
	}
	public List<Boat> findByMotorPowerAndMotorNumber(double motorPower, int motorNumber){
		return this.boatRepository.findByMotorPowerAndMotorNumber(motorPower,motorNumber);
	}
	public List<Boat> sortByName(){
		return this.boatRepository.findByOrderByName();
	}
	public List<Boat> sortByGrade(){
		return this.boatRepository.findByOrderByGradeDesc();
	}
	public List<Boat> sortByCity(){
		List<Boat> allBoats=this.boatRepository.findAll();
		List<Address> allAddressesSortByCities=this.addressRepository.findByOrderByCity();
		List<Boat> res=new ArrayList<>();
		for (Address address : allAddressesSortByCities) {
			for (Boat boat : allBoats) {
				if(boat.getAddress().getId().equals(address.getId())  ) {
					res.add(boat);
				}
			}
		}
		return res;
	}
	public List<AdditionalItem> findAllAdditionalItems(){
		return this.additionalItemRepository.findAll();
	}
	public List<Boat> findByName(String name){
		return this.boatRepository.findByName(name);
	}
	public List<Boat> findByCity(String city){
		List<Boat> all=this.boatRepository.findAll();
		List<Boat> res=new ArrayList<>();
		for (Boat boat : all) {
			if(boat.getAddress().getCity().equals(city)) {
				res.add(boat);
			}
		}
		return res;
	}
}
