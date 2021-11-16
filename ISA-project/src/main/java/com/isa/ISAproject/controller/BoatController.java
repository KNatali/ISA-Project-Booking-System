package com.isa.ISAproject.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Cottage;
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
	@RequestMapping(value="api/boats/{id}",method = RequestMethod.GET)
	public ResponseEntity<Boat>  findOne(@PathVariable Long id){
		Optional<Boat> boat=this.boatService.getOne(id);
		if (boat.isPresent()) {
			return new ResponseEntity<>(boat.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value="api/boats", method = RequestMethod.GET,
			params = "motorNumber",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Boat>> findByMotorNumber(@RequestParam int motorNumber){
		List<Boat> boats=this.boatService.findByMotorNumber(motorNumber);
		return new ResponseEntity<>(boats,HttpStatus.OK);
	}
	@RequestMapping(value="api/boats", method = RequestMethod.GET,
			params = "motorPower",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Boat>> findByMotorPower(@RequestParam double motorPower){
		List<Boat> boats=this.boatService.findByMotorPower(motorPower);
		return new ResponseEntity<>(boats,HttpStatus.OK);
	}
	@RequestMapping(value="api/boats", method = RequestMethod.GET,
			params = {"motorPower","motorNumber"},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Boat>> findByMotorPower(@RequestParam double motorPower,@RequestParam int motorNumber){
		List<Boat> boats=this.boatService.findByMotorPowerAndMotorNumber(motorPower, motorNumber);
		return new ResponseEntity<>(boats,HttpStatus.OK);
	}

}
