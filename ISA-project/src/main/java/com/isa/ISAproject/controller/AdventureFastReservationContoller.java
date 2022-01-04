package com.isa.ISAproject.controller;

import java.util.ArrayList;
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

import com.isa.ISAproject.dto.AdventureAddDTO;
import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.service.AdventureFastReservationService;

@CrossOrigin("*")
@RestController
public class AdventureFastReservationContoller {
	
	@Autowired
	private AdventureFastReservationService adventureFastReservationService;
	
	@RequestMapping(
			value="api/instructors/fastReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdventureFastReservationDTO>> getFastReservationsByInstructor(@PathVariable(name="id") Long instructorId){
		List<AdventureFastReservationDTO> list=new ArrayList<>();
		list=this.adventureFastReservationService.getFastReservationsByInstructor(instructorId);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/instructor/adventure/fastReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdventureFastReservationDTO>> getFastReservationsByAdventure(@PathVariable(name="id") Long adventureId){
		List<AdventureFastReservationDTO> list=new ArrayList<>();
		list=this.adventureFastReservationService.getFastReservationsByAdventure(adventureId);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/adventureReservation/addFastReservation",method = RequestMethod.PUT,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<AdventureFastReservationDTO>  addAdventureFastReservation(@RequestBody AdventureFastReservationDTO dto){
		AdventureFastReservationDTO fastDTO=this.adventureFastReservationService.addAdventureFastReservation( dto);
		if(fastDTO==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(fastDTO,HttpStatus.OK);
		
	}

}
