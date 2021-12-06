package com.isa.ISAproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.service.AdventureReservationService;

@CrossOrigin("*")
@RestController
public class AdventureReservationsController {
	@Autowired
	private AdventureReservationService adventureReservationService;
	
	@RequestMapping(value="api/adventure-reservations/{id}",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<AdventureReservationDTO>> findAllResrvationsByClient(@PathVariable Long id){
		List<AdventureReservation> res=this.adventureReservationService.findAllResByIdClient(id);
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
	public ResponseEntity<List<AdventureReservationDTO>> activeReservations(@PathVariable Long id){
		List<AdventureReservation> res=this.adventureReservationService.activeReservation(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
}
