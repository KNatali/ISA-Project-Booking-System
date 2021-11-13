package com.isa.ISAproject.controller;

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

import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.service.InstructorService;



@CrossOrigin("*")
@RestController
public class InstructorController {
	@Autowired
	private InstructorService instructorService;
	
	@RequestMapping(value="api/instructors/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InstructorProfileDTO> getById(@PathVariable Long id){
		Optional<Instructor> item=instructorService.findById(id);
		
		if(!item.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		InstructorProfileDTO itemDto=new InstructorProfileDTO(item.get());
		return new ResponseEntity<>(itemDto,HttpStatus.OK);
	}
}
