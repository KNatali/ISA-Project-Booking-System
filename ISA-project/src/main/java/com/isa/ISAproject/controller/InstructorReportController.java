package com.isa.ISAproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.InstructorReportDTO;
import com.isa.ISAproject.dto.ProfileDeleteRequestDTO;
import com.isa.ISAproject.dto.RegistrationRequestDTO;
import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.service.EmailService;
import com.isa.ISAproject.service.InstructorReportService;

@CrossOrigin("*")
@RestController
public class InstructorReportController {
	
	@Autowired
	private InstructorReportService instructorReportService;
	@Autowired
	private EmailService emailService;

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@RequestMapping(value="/api/instructors/sendReservationReport",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<?> sendReservationReport(@RequestBody InstructorReportDTO dto){
	
		InstructorReportDTO req=instructorReportService.saveReservationReport(dto);
		return new ResponseEntity<>(req,HttpStatus.OK);
	}
	@RequestMapping(value="api/admin/allReservationReports",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SYSADMIN') || hasRole('ADMIN')")
	public ResponseEntity<List<InstructorReportDTO>> getAllReservationReports(){
		List<InstructorReportDTO> dtos=instructorReportService.findAll();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/acceptInstructorReport",method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<?> acceptInstructorReport(@RequestBody InstructorReportDTO dto){
		instructorReportService.acceptReport(dto);
	
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendMessage(dto.getAdventureReservation().getClient().getEmail(),"Bad news:You have got 1 penal! Please be careful on your next trip.");
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendMessage(dto.getAdventureReservation().getAdventure().getInstructor().getEmail(),"Admin aproved your reservation report.Client have got 1 penal!");
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/rejectInstructorReport",method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<?> rejectInstructorReport(@RequestBody InstructorReportDTO dto){
		instructorReportService.rejectReport(dto);
	
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendMessage(dto.getAdventureReservation().getClient().getEmail(),"Good news:You dind't get 1 penal. Be careful next time!");
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendMessage(dto.getAdventureReservation().getAdventure().getInstructor().getEmail(),"Admin didn't aproved your registration report.CLient didn'e get 1 penal!");
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
