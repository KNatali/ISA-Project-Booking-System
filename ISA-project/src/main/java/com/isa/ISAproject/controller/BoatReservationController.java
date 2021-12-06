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

import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.service.BoatReservationService;

@CrossOrigin("*")
@RestController
public class BoatReservationController {
	@Autowired
	private BoatReservationService boatReservationService;
	
	@RequestMapping(value="api/boat-reservations/{id}",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<BoatReservationDTO>> findAllResrvationsByClient(@PathVariable Long id){
		List<BoatReservation> res=this.boatReservationService.findAllResByIdClient(id);
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	
	public List<BoatReservationDTO> convertToDTOList(List<BoatReservation> input){
		List<BoatReservationDTO> res=new ArrayList<>();
		for (BoatReservation boatReservation : input) {
			res.add(new BoatReservationDTO(boatReservation));
		}
		return res;
	}
}
