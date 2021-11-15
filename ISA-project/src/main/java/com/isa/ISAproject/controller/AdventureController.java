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

import com.isa.ISAproject.service.AdventureService;


@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/adventures")
public class AdventureController {
	@Autowired
	private AdventureService adventureService;
	
	@RequestMapping(method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Adventure>> findAll(){
		List<Adventure> adventures=adventureService.findAll();
		return new ResponseEntity<>(adventures,HttpStatus.OK);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Adventure>  findOne(@PathVariable Long id){
		Optional<Adventure> adventure=this.adventureService.getOne(id);
		if (adventure.isPresent()) {
			return new ResponseEntity<>(adventure.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
