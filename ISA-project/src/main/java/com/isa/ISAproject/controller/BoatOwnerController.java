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

import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.BoatOwnerProfileDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.PasswordChangeDTO;
import com.isa.ISAproject.mapper.BoatMapper;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.service.AddressService;
import com.isa.ISAproject.service.BoatOwnerService;
import com.isa.ISAproject.service.BoatService;

@CrossOrigin("*")
@RestController
public class BoatOwnerController {
	@Autowired
	private BoatOwnerService boatOwnerService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private BoatService boatService;
	
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
		if(!a.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
	
	@RequestMapping(value = "api/boatOwners/boats/delete/{id}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	//public ResponseEntity<BoatDTO> delete(@PathVariable Long id){
	public ResponseEntity delete(@PathVariable Long id){
		this.boatService.deleteBoat(id);
		return new ResponseEntity<>(HttpStatus.OK);
		/*BoatDTO bDTO=this.boatService.findById(id);
		if(bDTO==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		this.boatService.delete(id);
		return new ResponseEntity<>(bDTO,HttpStatus.OK);*/
	}
	@RequestMapping(value="api/boatOwners/changePassword/{id}",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<BoatOwnerProfileDTO> changePassword(@RequestBody PasswordChangeDTO dto,@PathVariable Long id){
		BoatOwnerProfileDTO boatOwnerDTO=boatOwnerService.changePassword(id, dto);
		if(boatOwnerDTO==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(boatOwnerDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/boat-owners",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<List<BoatOwnerProfileDTO>> findAll(){
		List<BoatOwner> boatOwners=this.boatOwnerService.findAll();
		List<BoatOwnerProfileDTO> dtos=this.convertIntoDTO(boatOwners);
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	private List<BoatOwnerProfileDTO> convertIntoDTO(List<BoatOwner> boatOwners){
		List<BoatOwnerProfileDTO> dtos=new ArrayList<>();
		for (BoatOwner bo : boatOwners) {
			dtos.add(new BoatOwnerProfileDTO(bo));
		}
		return dtos;
	}
	@RequestMapping(
			value="api/boatOwners/boats/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<List<BoatDTO>> boats(@PathVariable(name="id") Long id){
		Optional<BoatOwner> itemOptionals=this.boatOwnerService.findById(id);
		if(!itemOptionals.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		BoatOwner boatOwner=itemOptionals.get();
			Set<Boat> boats=boatOwner.getBoats();
			List<BoatDTO> boatsDTO=new ArrayList<>();
			
			for(Boat b: boats) {
				BoatDTO boat=BoatMapper.convertToDTO(b);
				boatsDTO.add(boat);
			}
			return new ResponseEntity<>(boatsDTO,HttpStatus.OK);
	}
	@RequestMapping(
			value="api/boatOwners/reservationClient/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<ClientProfileDTO> getReservationClient(@PathVariable(name="id") Long id){
		ClientProfileDTO dto=boatOwnerService.getReservationClilent(id);
		if(dto==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	@RequestMapping(
			value="api/boatOwners/activeReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<List<BoatReservationDTO>> getActiveReservations(@PathVariable(name="id") Long id){
		List<BoatReservationDTO> list=new ArrayList<>();
		list=this.boatOwnerService.getActiveReservations(id);
			
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/boatOwners/upcomingReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<List<BoatReservationDTO>> getUpcomingReservations(@PathVariable(name="id") Long id){
		List<BoatReservationDTO> list=new ArrayList<>();
		list=this.boatOwnerService.getUpcomingReservations(id);
			
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/boatOwners/completedReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<List<BoatReservationDTO>> getCompletedReservations(@PathVariable(name="id") Long id){
		List<BoatReservationDTO> list=new ArrayList<>();
		list=this.boatOwnerService.getCompletedReservations(id);
			
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
}
