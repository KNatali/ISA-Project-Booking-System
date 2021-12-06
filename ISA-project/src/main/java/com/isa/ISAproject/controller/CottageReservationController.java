package com.isa.ISAproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.service.CottageReservationService;

@CrossOrigin("*")
@RestController
public class CottageReservationController {
	@Autowired
	private CottageReservationService cottageReservationService;
	
	@RequestMapping(value="api/cottages-reservations/{id}",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<CottageReservationDTO>> findAllResrvationsByClient(@PathVariable Long id){
		List<CottageReservation> all=this.cottageReservationService.findAll();
		List<CottageReservation> res=new ArrayList<>();
		for (CottageReservation cottageReservation : all) {
			if(cottageReservation.getClient().getId().equals(id)) {
				res.add(cottageReservation);
			}
		}
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	public List<CottageReservationDTO> convertToDTOList(List<CottageReservation> input){
		List<CottageReservationDTO> res=new ArrayList<>();
		for (CottageReservation cottageReservation : input) {
			res.add(new CottageReservationDTO(cottageReservation));
		}
		return res;
	}
	@RequestMapping(value="api/cottages-reservations/sort-by-price", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<CottageReservationDTO>> sortByPrice(){
		List<CottageReservation> res=this.cottageReservationService.sortByPrice();
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages-reservations/sort-by-duration", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<CottageReservationDTO>> sortByDuration(){
		List<CottageReservation> res=this.cottageReservationService.sortByDuration();
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages-reservations/sort-by-date", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<CottageReservationDTO>> sortByDate(){
		List<CottageReservation> res=this.cottageReservationService.sortByDate();
		return new ResponseEntity<>(this.convertToDTOList(res),HttpStatus.OK);
	}
	
}
