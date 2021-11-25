package com.isa.ISAproject.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.CottageOwnerProfileDTO;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.CottageOwner;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.service.AddressService;
import com.isa.ISAproject.service.CottageOwnerService;

@CrossOrigin("*")
@RestController
public class CottageOwnerController {
	@Autowired
	private CottageOwnerService cottageOwnerService;
	@Autowired
	private AddressService addressService;
	@RequestMapping(value="api/cottageOwner/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CottageOwnerProfileDTO> getById(@PathVariable Long id){
		Optional<CottageOwner> item=cottageOwnerService.findById(id);
		
		if(!item.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		CottageOwnerProfileDTO itemDto=new CottageOwnerProfileDTO(item.get());
		return new ResponseEntity<>(itemDto,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/cottageOwner/{id}",method = RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CottageOwnerProfileDTO> update(@RequestBody CottageOwnerProfileDTO editedCottageOwnerDTO,@PathVariable Long id){
		Optional<CottageOwner> itemOptionals=this.cottageOwnerService.findById(id);
		
		if(!itemOptionals.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		CottageOwner cottageOwner=itemOptionals.get();
		cottageOwner.setId(id);
		cottageOwner.setFirstName(editedCottageOwnerDTO.getFirstName());
		cottageOwner.setLastName(editedCottageOwnerDTO.getLastName());
		Optional<Address> a=this.addressService.findById(cottageOwner.getAddress().getId());
			Address address=a.get();
				address.setId(cottageOwner.getAddress().getId());
				address.setStreet(editedCottageOwnerDTO.getStreet());
				address.setCity(editedCottageOwnerDTO.getCity());
				address.setState(editedCottageOwnerDTO.getState());
				this.addressService.save(address);
				
				cottageOwner.setAddress(address);
				cottageOwner.setEmail(editedCottageOwnerDTO.getEmail());
				cottageOwner.setMobile(editedCottageOwnerDTO.getMobile());
		
		
		final CottageOwner savedCottageOwner=this.cottageOwnerService.save(cottageOwner);
		
		
		return new ResponseEntity<>(new CottageOwnerProfileDTO(savedCottageOwner),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottage-owners",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
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
}
