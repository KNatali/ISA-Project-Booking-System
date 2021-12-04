package com.isa.ISAproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
}
