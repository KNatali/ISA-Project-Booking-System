package com.isa.ISAproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.service.AnalyticsService;
import com.isa.ISAproject.service.CottageOwnerService;
import com.isa.ISAproject.service.InstructorService;

@CrossOrigin("*")
@RestController
public class AnalyticsController {

	
	@Autowired
	private AnalyticsService analyticsService;
	@Autowired
	private InstructorService instructorService;
	@Autowired
	private CottageOwnerService cottageOwnerService;
	
	@RequestMapping(value="api/adventureReservation/periodEarnings",method = RequestMethod.POST,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public @ResponseBody Double getAdventureEarnings(@RequestBody TimePeriodDTO dto){
		
		return analyticsService.getAdventureEarnings(dto);
	}
	
	@RequestMapping(value="api/adventureReservation/instructorEarnings/{id}",method = RequestMethod.POST,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public @ResponseBody Double getInstructorPeriodEarnings(@RequestBody TimePeriodDTO dto,@PathVariable Long id){
		
		return analyticsService.getInstructorEarnings(dto,id);
	}
	@RequestMapping(
			value="api/instructor/reservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<List<AdventureReservationDTO>> getActiveReservations(@PathVariable(name="id") Long id){
		List<AdventureReservationDTO> list=new ArrayList<>();
		list=this.analyticsService.getInstructorReservations(id);
			
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/instructor/averageGrade/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public @ResponseBody Double instructrAverageGrade(@PathVariable(name="id") Long id){
		
		return analyticsService.instructrAverageGrade(id);
	}
	
	/**/
	
	@RequestMapping(value="api/cottageReservation/cottageOwnerEarnings/{id}",method = RequestMethod.POST,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public @ResponseBody Double getCottageOwnerPeriodEarnings(@RequestBody TimePeriodDTO dto,@PathVariable Long id){
		
		return analyticsService.getCottageOwnerEarnings(dto,id);
	}

	@RequestMapping(
			value="api/cottageOwner/reservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<List<CottageReservationDTO>> getActiveReservationsCottage(@PathVariable(name="id") Long id){
		List<CottageReservationDTO> list=new ArrayList<>();
		list=this.analyticsService.getCottageOwnerReservations(id);
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/cottageOwner/averageGrade/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public @ResponseBody Double cottageOwnerAverageGrade(@PathVariable(name="id") Long id){
		
		return analyticsService.cottageOwnerAverageGrade(id);
	}
	
	/**/
	
	@RequestMapping(value="api/boatReservation/boatOwnerEarnings/{id}",method = RequestMethod.POST,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public @ResponseBody Double getBoatOwnerPeriodEarnings(@RequestBody TimePeriodDTO dto,@PathVariable Long id){
		
		return analyticsService.getBoatOwnerEarnings(dto,id);
	}

	@RequestMapping(
			value="api/boatOwner/reservations/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<List<BoatReservationDTO>> getActiveReservationsBoat(@PathVariable(name="id") Long id){
		List<BoatReservationDTO> list=new ArrayList<>();
		list=this.analyticsService.getBoatOwnerReservations(id);
			return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@RequestMapping(
			value="api/boatOwner/averageGrade/{id}",method = RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public @ResponseBody Double boatOwnerAverageGrade(@PathVariable(name="id") Long id){
		
		return analyticsService.boatOwnerAverageGrade(id);
	}
}
