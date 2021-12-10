package com.isa.ISAproject.controller;

import java.util.List;

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

import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.service.AddressService;
import com.isa.ISAproject.service.CottageOwnerService;
import com.isa.ISAproject.service.CottageService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/cottageOwner/cottage")
public class CottageOwnerCottageController {
	@Autowired
	private CottageOwnerService cottageOwnerService;
	@Autowired
	private CottageService cottageService;
	@Autowired
	private AddressService addressService;
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<?> editCottage(@RequestBody CottageDTO dto,@PathVariable Long id){
		this.cottageService.editCottage(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
