package com.isa.ISAproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.ProfileDeleteRequestDTO;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.service.TimePeriodService;

@CrossOrigin("*")
@RestController
public class TimePeriodController {
	
	@Autowired
	private TimePeriodService timePeriodService;
	
	@RequestMapping(value="api/instructors/setUnavailability/{id}",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<?> setUnavailabilityInstructor(@RequestBody TimePeriodDTO dto,@PathVariable Long id){
		if(timePeriodService.setUnavailabilityInstructor(dto,id))
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

	@RequestMapping(value="api/instructors/getUnavailability/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<TimePeriodDTO>> getUnavailabilityByInstructor(@PathVariable Long id){
		List<TimePeriodDTO> dtos=timePeriodService.findUnavailabilityByInstructor(id);
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}

}