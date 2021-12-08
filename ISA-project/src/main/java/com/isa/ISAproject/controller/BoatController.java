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

import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.service.BoatService;

import net.bytebuddy.asm.Advice.This;


@CrossOrigin("*")
@RestController
public class BoatController {
	@Autowired
	private BoatService boatService;
	
	@RequestMapping(value="api/boats",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<BoatDTO>> findAll(){
		List<Boat> boats=boatService.findAll();
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	public List<BoatDTO> convert(List<Boat> boats){
		List<BoatDTO> res=new ArrayList<>();
		for (Boat boat: boats) {
			res.add(new BoatDTO(boat));
		}
		return res;
	}
	@RequestMapping(value="api/boats/{id}",method = RequestMethod.GET)
	public ResponseEntity<BoatDTO>  findOne(@PathVariable Long id){
		Optional<Boat> boat=this.boatService.getOne(id);
		if (!boat.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(new BoatDTO(boat.get()), HttpStatus.OK);
	}
	@RequestMapping(value="api/boats", method = RequestMethod.GET,
			params = "motorNumber",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BoatDTO>> findByMotorNumber(@RequestParam int motorNumber){
		List<Boat> boats=this.boatService.findByMotorNumber(motorNumber);
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats", method = RequestMethod.GET,
			params = "motorPower",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BoatDTO>> findByMotorPower(@RequestParam double motorPower){
		List<Boat> boats=this.boatService.findByMotorPower(motorPower);
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats", method = RequestMethod.GET,
			params = {"motorPower","motorNumber"},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BoatDTO>> findByMotorPower(@RequestParam double motorPower,@RequestParam int motorNumber){
		List<Boat> boats=this.boatService.findByMotorPowerAndMotorNumber(motorPower, motorNumber);
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/sort-by-name", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BoatDTO>> sortByName(){
		List<Boat> boats=this.boatService.sortByName();
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/sort-by-grade", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BoatDTO>> sortByGrade(){
		List<Boat> boats=this.boatService.sortByGrade();
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}
	@RequestMapping(value="api/boats/sort-by-city", method = RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<BoatDTO>> sortByCity(){
		List<Boat> boats=this.boatService.sortByCity();
		return new ResponseEntity<>(this.convert(boats),HttpStatus.OK);
	}

}
