package com.isa.ISAproject.controller;

import java.time.DateTimeException;
import java.util.List;

import javax.persistence.PessimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
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

import javassist.NotFoundException;

@CrossOrigin("*")
@RestController
public class TimePeriodController {
	
	@Autowired
	private TimePeriodService timePeriodService;
	
	@RequestMapping(value="api/instructors/setUnavailability/{id}",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<?> setUnavailabilityInstructor(@RequestBody TimePeriodDTO dto,@PathVariable Long id){
		try {
			timePeriodService.setUnavailabilityInstructor(dto,id);
		}catch(PessimisticLockException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}catch(DateTimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);	
			
	}
	

	@RequestMapping(value="api/instructors/getUnavailability/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<TimePeriodDTO>> getUnavailabilityByInstructor(@PathVariable Long id){
		List<TimePeriodDTO> dtos=timePeriodService.findUnavailabilityByInstructor(id);
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	/**/
	
	/*@RequestMapping(value="api/cottages/setUnavailability/{id}",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<?> setUnavailabilityCottageOwner(@RequestBody TimePeriodDTO dto,@PathVariable Long id){
		try {
			timePeriodService.setUnavailabilityCottageOwner(dto,id);
		}catch(PessimisticLockingFailureException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}catch(DateTimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	*/
	/*@RequestMapping(value="api/cottages/getUnavailability/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<TimePeriodDTO>> getUnavailabilityByCottageOwner(@PathVariable Long id){
		List<TimePeriodDTO> dtos=timePeriodService.findUnavailabilityByCottageOwner(id);
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	*/
	/**/
	
	/*@RequestMapping(value="api/boats/setUnavailability/{id}",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<?> setUnavailabilityBoatOwner(@RequestBody TimePeriodDTO dto,@PathVariable Long id){
		try {
			timePeriodService.setUnavailabilityBoatOwner(dto,id);
		}catch(PessimisticLockingFailureException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}catch(DateTimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);		
	}*/
	
	@RequestMapping(value="api/boats/getUnavailability/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<List<TimePeriodDTO>> getUnavailabilityByBoat(@PathVariable Long id){
		List<TimePeriodDTO> dtos=timePeriodService.findUnavailabilityByBoat(id);
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/boats/setUnavailability/{id}",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<?> setUnavailabilityBoat(@RequestBody TimePeriodDTO dto,@PathVariable Long id){
		try {
			timePeriodService.setUnavailabilityBoat(dto,id);
		}catch(PessimisticLockException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}catch(DateTimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);	
			
	}
	@RequestMapping(value="api/cottages/getUnavailability/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<TimePeriodDTO>> getUnavailabilityByCottage(@PathVariable Long id){
		List<TimePeriodDTO> dtos=timePeriodService.findUnavailabilityByCottage(id);
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="api/cottages/setUnavailability/{id}",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<?> setUnavailabilityCottage(@RequestBody TimePeriodDTO dto,@PathVariable Long id){
		try {
			timePeriodService.setUnavailabilityCottage(dto,id);
		}catch(PessimisticLockException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}catch(DateTimeException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);	
			
	}
	

}
