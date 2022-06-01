package com.isa.ISAproject.controller;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
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

import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.dto.BoatFastReservationDTO;
import com.isa.ISAproject.dto.EditBoatFastReservationDTO;
import com.isa.ISAproject.service.BoatFastReservationService;

@CrossOrigin("*")
@RestController
public class BoatFastResevationController {

	@Autowired
	private BoatFastReservationService boatFastReservationService;
	
	@RequestMapping(
			value="api/boatOwners/fastReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<List<BoatFastReservationDTO>> getFastReservationsByBoatOwner(@PathVariable(name="id") Long boatOwnerId){
		List<BoatFastReservationDTO> list=new ArrayList<>();
		list=this.boatFastReservationService.getFastReservationsByBoatOwner(boatOwnerId);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/boatOwner/boat/fastReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<List<BoatFastReservationDTO>> getFastReservationsByBoat(@PathVariable(name="id") Long boatId){
		List<BoatFastReservationDTO> list=new ArrayList<>();
		list=this.boatFastReservationService.getFastReservationsByBoat(boatId);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@RequestMapping(
			value="api/boat/fastReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<BoatFastReservationDTO>> getFastReservationsByBoatClient(@PathVariable(name="id") Long boatId){
		List<BoatFastReservationDTO> list=new ArrayList<>();
		list=this.boatFastReservationService.getFastReservationsByBoatClient(boatId);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/boatReservation/addFastReservation",method = RequestMethod.PUT,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('BOAT_OWNER')")	
	public ResponseEntity<BoatFastReservationDTO>  addBoatFastReservation(@RequestBody BoatFastReservationDTO dto){
		BoatFastReservationDTO fastDTO=new BoatFastReservationDTO();
		try {
			fastDTO = this.boatFastReservationService.addBoatFastReservation(dto);
		} catch (PessimisticLockingFailureException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (DateTimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(fastDTO,HttpStatus.OK);	
	}
	
	@RequestMapping(value="api/boatReservation/editFastReservation",method = RequestMethod.POST,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<BoatFastReservationDTO>  editBoatFastReservation(@RequestBody EditBoatFastReservationDTO dto) throws Exception{
		BoatFastReservationDTO fastDTO=this.boatFastReservationService.editBoatFastReservation(dto);
		if(fastDTO==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(fastDTO,HttpStatus.OK);
	}
}
