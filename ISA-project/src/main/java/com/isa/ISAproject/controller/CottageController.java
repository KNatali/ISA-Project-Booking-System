package com.isa.ISAproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.service.CottageService;

@CrossOrigin("*")
@RestController
public class CottageController {
	@Autowired
	private CottageService cottageService;
	
	@RequestMapping(value="api/cottages",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Cottage>> findAll(){
		List<Cottage> cottages=cottageService.findAll();
		return new ResponseEntity<>(cottages,HttpStatus.OK);
	}
	@RequestMapping(value="api/cottages/{id}",method = RequestMethod.GET)
	public ResponseEntity<Cottage>  findOne(@PathVariable Long id){
		Optional<Cottage> cottage=this.cottageService.getOne(id);
		if (cottage.isPresent()) {
			return new ResponseEntity<>(cottage.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
