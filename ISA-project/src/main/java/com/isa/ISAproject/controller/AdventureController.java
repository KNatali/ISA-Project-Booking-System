package com.isa.ISAproject.controller;

import java.io.Console;
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

import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.service.AdventureService;
import com.isa.ISAproject.service.InstructorService;


@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/adventures")
public class AdventureController {
	@Autowired
	private AdventureService adventureService;
	
	@Autowired
	private InstructorService instructorService;
	
	@RequestMapping(method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<AdventureDTO>> findAll(){
		List<Adventure> adventures=adventureService.findAll();
		
List<AdventureDTO> adventuresDTO=new ArrayList<>();
		
		for(Adventure a:adventures) {
			InstructorProfileDTO insDTO=new InstructorProfileDTO(a.getInstructor());
			AdventureDTO filmDTO=new AdventureDTO(a.getId(),a.getName(),a.getAddress(),a.getDescription(),a.getAverageGrade(),insDTO,a.getMainPicture());
			adventuresDTO.add(filmDTO);
		}
		return new ResponseEntity<>(adventuresDTO,HttpStatus.OK);
	}/*
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Adventure>  findOne(@PathVariable Long id){
		Optional<Adventure> adventure=this.adventureService.getOne(id);
		if (adventure.isPresent()) {
			return new ResponseEntity<>(adventure.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<AdventureDTO>  findOne(@PathVariable Long id){
		Optional<Adventure> adventure=this.adventureService.getOne(id);
		if (adventure.isPresent()) {
			Adventure a=adventure.get();
			InstructorProfileDTO insDTO=new InstructorProfileDTO(a.getInstructor());
			AdventureDTO adventureDto=new AdventureDTO(a.getId(),a.getName(),a.getAddress(),a.getDescription(),a.getAverageGrade(),insDTO,a.getMainPicture());
			return new ResponseEntity<>(adventureDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping( method = RequestMethod.GET,
			params = {"firstName","lastName"},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<AdventureDTO>> findAdventureByInstructor(@RequestParam String firstName,@RequestParam String lastName){
		Instructor instructor=this.instructorService.findByFirstNameAndLastName(firstName, lastName);
		InstructorProfileDTO insDTO=new InstructorProfileDTO(instructor);
		List<Adventure> adventures=this.adventureService.findByInstructor(instructor);
		if(adventures==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<AdventureDTO> res=new ArrayList<>();
		for (Adventure a : adventures) {
			res.add(new AdventureDTO(a.getId(),a.getName(),a.getAddress(),a.getDescription(),a.getAverageGrade(),insDTO,a.getMainPicture()));
		}
		return new ResponseEntity<>(res,HttpStatus.OK);
	}

}
