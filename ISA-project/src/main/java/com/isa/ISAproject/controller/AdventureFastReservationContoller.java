package com.isa.ISAproject.controller;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PessimisticLockException;

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

import com.isa.ISAproject.dto.AdventureAddDTO;
import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.EditAdventureFastReservationDTO;
import com.isa.ISAproject.dto.ReserveAdventureFastResrvationDTO;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.model.AdventureFastReservation;
import com.isa.ISAproject.service.AdventureFastReservationService;
import com.isa.ISAproject.service.AdventureReservationService;

@CrossOrigin("*")
@RestController
public class AdventureFastReservationContoller {
	
	@Autowired
	private AdventureFastReservationService adventureFastReservationService;
	@Autowired
	private AdventureReservationService adventureReservationService;
	
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
	@RequestMapping(
			value="api/adventure/fastReservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureFastReservationDTO>> getFastReservationsByAdventureClient(@PathVariable(name="id") Long adventureId){
		List<AdventureFastReservationDTO> list=new ArrayList<>();
		list=this.adventureFastReservationService.getFastReservationsByAdventureClient(adventureId);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/adventureReservation/addFastReservation",method = RequestMethod.PUT,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<AdventureFastReservationDTO>  addAdventureFastReservation(@RequestBody AdventureFastReservationDTO dto){
		AdventureFastReservationDTO fastDTO=new AdventureFastReservationDTO();
		try {
			fastDTO = this.adventureFastReservationService.addAdventureFastReservation( dto);
		} catch (PessimisticLockException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (DateTimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(fastDTO,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="api/adventureReservation/editFastReservation",method = RequestMethod.POST,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<AdventureFastReservationDTO>  editAdventureFastReservation(@RequestBody EditAdventureFastReservationDTO dto) throws Exception{
		AdventureFastReservationDTO fastDTO=this.adventureFastReservationService.editAdventureFastReservation( dto);
		if(fastDTO==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(fastDTO,HttpStatus.OK);
		
	}
	@RequestMapping(value="api/adventure/fastReservations/reserve",method = RequestMethod.POST,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<AdventureReservationDTO> reserveFastReservation(@RequestBody ReserveAdventureFastResrvationDTO dto){
		AdventureReservationDTO reservationDTO=this.adventureFastReservationService.convertToAdventureReservation(dto);
		AdventureReservationDTO created = null;
		try {
			created = this.adventureReservationService.addAdventureReservation(reservationDTO);
		} catch (PessimisticLockException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DateTimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		//treba izbrisati tu akciju
		AdventureFastReservation fast=this.adventureFastReservationService.findById(dto.getId());
		this.adventureFastReservationService.delite(fast);
		return new ResponseEntity<>(created,HttpStatus.OK);
	}

}
