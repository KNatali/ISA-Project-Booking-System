package com.isa.ISAproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.service.BoatService;


@CrossOrigin("*")
@RestController
public class BoatController {
	@Autowired
	private BoatService boatService;
	
	@RequestMapping(value="api/boats",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Boat>> findAll(){
		List<Boat> boats=boatService.findAll();
		return new ResponseEntity<>(boats,HttpStatus.OK);
	}

}
