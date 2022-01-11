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
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.service.AdventureReservationService;

import javassist.NotFoundException;

@CrossOrigin("*")
@RestController
public class AdventureReservationsController {
	@Autowired
	private AdventureReservationService adventureReservationService;
	
	@RequestMapping(value="api/adventureReservation/all",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<List<AdventureReservationDTO>> findAllResrvations(){
		List<AdventureReservation> list=this.adventureReservationService.findAll();
		List<AdventureReservationDTO> res=new ArrayList<>();
		for (AdventureReservation advReservation : list) {
			AdventureReservationDTO a=new AdventureReservationDTO(advReservation);
			a.setSystemEarning(advReservation.getSystemEarning());
			res.add(a);
		}
		return new ResponseEntity<>(res,HttpStatus.OK);
	}

	
	
	@RequestMapping(value="api/adventure-reservations/{id}",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureReservationDTO>> findAllResrvationsByClient(@PathVariable Long id){
		List<AdventureReservation> res=this.adventureReservationService.oldReservation(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	
	public List<AdventureReservationDTO> convertToDTOList(List<AdventureReservation> input){
		List<AdventureReservationDTO> res=new ArrayList<>();
		for (AdventureReservation advReservation : input) {
			res.add(new AdventureReservationDTO(advReservation));
		}
		return res;
	}

	@RequestMapping(value="api/adventure-reservations/active/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureReservationDTO>> activeReservations(@PathVariable Long id){
		List<AdventureReservation> res=this.adventureReservationService.activeReservation(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	@RequestMapping(value="api/adventure-reservations/sort-by-price/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureReservationDTO>> sortByPrice(@PathVariable Long id){
		List<AdventureReservation> res=this.adventureReservationService.sortByPrice(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	@RequestMapping(value="api/adventure-reservations/sort-by-date/{id}", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<List<AdventureReservationDTO>> sortByDate(@PathVariable Long id){
		List<AdventureReservation> res=this.adventureReservationService.sortByDateStart(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	
	@RequestMapping(value="api/adventureReservation/addReservation",method = RequestMethod.PUT,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<AdventureReservationDTO>  addAdventureReservation(@RequestBody AdventureReservationDTO dto) {
		AdventureReservationDTO fastDTO;
		try {
			fastDTO = this.adventureReservationService.addAdventureReservation( dto);
		} catch (PessimisticLockingFailureException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (DateTimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(fastDTO,HttpStatus.OK);
		
	}
}
