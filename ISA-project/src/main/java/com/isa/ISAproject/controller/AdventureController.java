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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.mapper.InstructorMapper;
import com.isa.ISAproject.model.Adventure;
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
		List<AdventureDTO> adventuresDTO=adventureService.findAll();
		
		return new ResponseEntity<>(adventuresDTO,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<AdventureDTO>  findOne(@PathVariable Long id){
		AdventureDTO adventureDTO=this.adventureService.findById(id);
		if (adventureDTO!=null) {
			
			return new ResponseEntity<>(adventureDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping( method = RequestMethod.GET,
			params = {"firstName","lastName"},
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<AdventureDTO>> findAdventureByInstructorName(@RequestParam String firstName,@RequestParam String lastName){
		Instructor instructor=this.instructorService.findByFirstNameAndLastName(firstName, lastName);
		InstructorProfileDTO insDTO=new InstructorProfileDTO(instructor);
		List<Adventure> adventures=this.adventureService.findByInstructor(instructor);
		if(adventures==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<AdventureDTO> res=AdventureMapper.convertoToDTOs(adventures);
		
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@RequestMapping( method = RequestMethod.GET,
			params = "instructorId",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<AdventureDTO>> findAdventureByInstructor(@RequestParam Long instructorId){
		Optional<Instructor> instructorOPT=this.instructorService.findById(instructorId);
		if(!instructorOPT.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Instructor instructor=instructorOPT.get();
		InstructorProfileDTO insDTO=InstructorMapper.convertToDTO(instructor);
		List<Adventure> adventures=this.adventureService.findByInstructor(instructor);
		if(adventures==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<AdventureDTO> res=AdventureMapper.convertoToDTOs(adventures);
		
		return new ResponseEntity<>(res,HttpStatus.OK);
	}

}
