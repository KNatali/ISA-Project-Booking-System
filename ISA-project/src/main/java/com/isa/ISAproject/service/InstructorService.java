package com.isa.ISAproject.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.mapper.AdventureReservationMapper;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.AddressRepository;
import com.isa.ISAproject.repository.AdventureReservationRepository;
import com.isa.ISAproject.repository.InstructorRepository;



@Service
public class InstructorService {
	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private AdventureReservationRepository reservationRepository;
	
	public List<Instructor> findAll() {
		return this.instructorRepository.findAll();
	}
	public Page<Instructor> findAll(Pageable page) {
		return instructorRepository.findAll(page);
	}
	public Optional<Instructor> findById(Long id) {
		return this.instructorRepository.findById(id);
	}
	
	public Instructor save(Instructor newInstructor) {
		return this.instructorRepository.save(newInstructor);
	}
	public Instructor findByFirstNameAndLastName(String firstName, String lastName) {
		return this.instructorRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	public List<Instructor> sortByFirstName(){
		return this.instructorRepository.findByOrderByFirstName();
	}
	public List<Instructor> sortByGrade(){
		return this.instructorRepository.findByOrderByGradeDesc();
	}
	
	public List<AdventureReservationDTO> getReservations(Long id){
		List<AdventureReservationDTO> res=new ArrayList<>();
		List<AdventureReservation> temp=new ArrayList<>();
		List<AdventureReservation> reservations=reservationRepository.findAll();
		for (AdventureReservation a : reservations) {
			if(a.getAdventure().getInstructor().getId()==id && a.getReservationStart().isAfter(LocalDateTime.now()))
				temp.add(a);
		}
		for (AdventureReservation a : temp) {
			res.add(AdventureReservationMapper.convertToDTO(a));
		}
		return res;
		
	}
	public List<AdventureReservationDTO> getCompletedReservations(Long id){
		List<AdventureReservationDTO> res=new ArrayList<>();
		List<AdventureReservation> temp=new ArrayList<>();
		List<AdventureReservation> reservations=reservationRepository.findAll();
		for (AdventureReservation a : reservations) {
			if(a.getAdventure().getInstructor().getId()==id && a.getReservationEnd().isBefore(LocalDateTime.now()))
				temp.add(a);
		}
		for (AdventureReservation a : temp) {
			res.add(AdventureReservationMapper.convertToDTO(a));
		}
		return res;
		
	}
	public List<Instructor> sortByCity(){
		List<Instructor> allInstrucotrs=this.instructorRepository.findAll();
		List<Address> allAddressesSortByCities=this.addressRepository.findByOrderByCity();
		List<Instructor> res=new ArrayList<>();
		for (Address address : allAddressesSortByCities) {
			for (Instructor instructors : allInstrucotrs) {
				if(instructors.getAddress().getId().equals(address.getId())  ) {
					res.add(instructors);
				}
			}
		}
		return res;
	}
}
