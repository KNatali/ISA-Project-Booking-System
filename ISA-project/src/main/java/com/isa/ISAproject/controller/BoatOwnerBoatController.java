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

import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.NavigationEquipmentDTO;
import com.isa.ISAproject.service.BoatService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/boatOwner/boat")
public class BoatOwnerBoatController {
	@Autowired
	private BoatService boatService;
	
	@RequestMapping(value="/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<?> editBoat(@RequestBody BoatDTO dto,@PathVariable Long id){
		this.boatService.editBoat(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/equipment/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<List<NavigationEquipmentDTO>> getBoatEquipment(@PathVariable Long id){
		List<NavigationEquipmentDTO> item=boatService.getNavigationEquipment(id);
		if(item==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
	@RequestMapping(value="/equipment/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<?> saveNewEquipment(@RequestBody NavigationEquipmentDTO dto,@PathVariable Long id){
		this.boatService.saveNewEquipment(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/equipmentEdit/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<?> editEquipment(@RequestBody NavigationEquipmentDTO dto,@PathVariable Long id){
		this.boatService.editEquipment(id, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/equipment/{boatId}/{equipmentId}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<?> deleteEquipment(@PathVariable(name="boatId") Long boatId,@PathVariable(name="equipmentId") Long equipmentId){
		if(this.boatService.deleteEquipment(boatId,equipmentId)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
