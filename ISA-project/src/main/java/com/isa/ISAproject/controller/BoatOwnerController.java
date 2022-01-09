package com.isa.ISAproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.BoatOwnerProfileDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.service.AddressService;
import com.isa.ISAproject.service.BoatOwnerService;

@CrossOrigin("*")
@RestController
public class BoatOwnerController {
	@Autowired
	private BoatOwnerService boatOwnerService;
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value="api/boatOwner/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<BoatOwnerProfileDTO> getById(@PathVariable Long id){
		Optional<BoatOwner> item=boatOwnerService.findById(id);
		
		if(!item.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		BoatOwnerProfileDTO itemDto=new BoatOwnerProfileDTO(item.get());
		return new ResponseEntity<>(itemDto,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/boatOwner/{id}",method = RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<BoatOwnerProfileDTO> update(@RequestBody BoatOwnerProfileDTO editedBoatOwnerDTO,@PathVariable Long id){
		Optional<BoatOwner> itemOptionals=this.boatOwnerService.findById(id);
		
		if(!itemOptionals.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		BoatOwner boatOwner=itemOptionals.get();
		boatOwner.setId(id);
		boatOwner.setFirstName(editedBoatOwnerDTO.getFirstName());
		boatOwner.setLastName(editedBoatOwnerDTO.getLastName());
		Optional<Address> a=this.addressService.findById(boatOwner.getAddress().getId());
			Address address=a.get();
				address.setId(boatOwner.getAddress().getId());
				address.setStreet(editedBoatOwnerDTO.getStreet());
				address.setCity(editedBoatOwnerDTO.getCity());
				address.setState(editedBoatOwnerDTO.getState());
				this.addressService.save(address);
				
				boatOwner.setAddress(address);
				boatOwner.setEmail(editedBoatOwnerDTO.getEmail());
				boatOwner.setMobile(editedBoatOwnerDTO.getMobile());
		
		
		final BoatOwner savedBoatOwner=this.boatOwnerService.save(boatOwner);
		
		
		return new ResponseEntity<>(new BoatOwnerProfileDTO(savedBoatOwner),HttpStatus.OK);
	}
	/*
	@RequestMapping(value="api/cottage-owners",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<CottageOwnerProfileDTO>> findAll(){
		List<CottageOwner> cottageOwners=this.cottageOwnerService.findAll();
		List<CottageOwnerProfileDTO> dtos=this.convertIntoDTO(cottageOwners);
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	private List<CottageOwnerProfileDTO> convertIntoDTO(List<CottageOwner> cottageOwners){
		List<CottageOwnerProfileDTO> dtos=new ArrayList<>();
		for (CottageOwner co : cottageOwners) {
			dtos.add(new CottageOwnerProfileDTO(co));
		}
		return dtos;
	}

	//
	
	@RequestMapping(
			value="api/cottageOwners/cottages/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<CottageDTO>> cottages(@PathVariable(name="id") Long id){
		Optional<CottageOwner> itemOptionals=this.cottageOwnerService.findById(id);
		if(!itemOptionals.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		CottageOwner cottageOwner=itemOptionals.get();
			Set<Cottage> cottages=cottageOwner.getCottages();
			List<CottageDTO> cottagesDTO=new ArrayList<>();
			
			for(Cottage c:cottages) {
				CottageDTO cottage=CottageMapper.convertToDTO(c);
				cottagesDTO.add(cottage);
			}
			return new ResponseEntity<>(cottagesDTO,HttpStatus.OK);
	}
	@RequestMapping(
			value="api/cottageOwners/reservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<CottageReservationDTO>> getReservations(@PathVariable(name="id") Long id){
		List<CottageReservationDTO> list=new ArrayList<>();
		list=this.cottageOwnerService.getReservations(id);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

	@RequestMapping(
			value="api/cottageOwners/fastReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<CottageFastReservationDTO>> getFastReservations(@PathVariable(name="id") Long id){
		List<CottageFastReservationDTO> list=new ArrayList<>();
		list=this.cottageOwnerService.getFastReservations(id);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/cottageOwners/reservationClient/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<ClientProfileDTO> getReservationClient(@PathVariable(name="id") Long id){
		ClientProfileDTO dto=cottageOwnerService.getReservationClilent(id);
		if(dto==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/cottageOwners/cottages/{id}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<CottageDTO> delete(@PathVariable Long id){
		CottageDTO cDTO=this.cottageService.findById(id);
		if(cDTO==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		this.cottageService.delete(id);
		return new ResponseEntity<>(cDTO,HttpStatus.OK);
	}
	@RequestMapping(value="api/cottageOwners/sort-by-name", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<CottageOwnerProfileDTO>> sortByFirstNameAndLastName(){
		List<CottageOwner> cottageOwners=this.cottageOwnerService.sortByFirstName();
		return new ResponseEntity<>(this.convertIntoDTO(cottageOwners),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottageOwners/sort-by-grade", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<CottageOwnerProfileDTO>> sortByGrade(){
		List<CottageOwner> cottageOwners=this.cottageOwnerService.sortByGrade();
		return new ResponseEntity<>(this.convertIntoDTO(cottageOwners),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottageOwners/sort-by-city", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<CottageOwnerProfileDTO>> sortByCity(){
		List<CottageOwner> cottageOwners=this.cottageOwnerService.sortByCity();
		return new ResponseEntity<>(this.convertIntoDTO(cottageOwners),HttpStatus.OK);
	}
	@RequestMapping(
			value="api/cottageOwners/cottages/client/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<CottageDTO>> cottagesForCottageOwner(@PathVariable(name="id") Long id){
		Optional<CottageOwner> itemOptionals=this.cottageOwnerService.findById(id);
		if(!itemOptionals.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		CottageOwner cottageOwner=itemOptionals.get();
			Set<Cottage> cottages=cottageOwner.getCottages();
			List<CottageDTO> cottagesDTO=new ArrayList<>();
			
			for(Cottage c:cottages) {
				CottageDTO cottage=CottageMapper.convertToDTO(c);
				cottagesDTO.add(cottage);
			}
			return new ResponseEntity<>(cottagesDTO,HttpStatus.OK);
	}
	@RequestMapping(
			value="api/cottageOwners/activeReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<CottageReservationDTO>> getActiveReservations(@PathVariable(name="id") Long id){
		List<CottageReservationDTO> list=new ArrayList<>();
		list=this.cottageOwnerService.getActiveReservations(id);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/cottageOwners/upcomingReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<CottageReservationDTO>> getUpcomingReservations(@PathVariable(name="id") Long id){
		List<CottageReservationDTO> list=new ArrayList<>();
		list=this.cottageOwnerService.getUpcomingReservations(id);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/cottageOwners/completedReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<CottageReservationDTO>> getCompletedReservations(@PathVariable(name="id") Long id){
		List<CottageReservationDTO> list=new ArrayList<>();
		list=this.cottageOwnerService.getCompletedReservations(id);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}*/
}
