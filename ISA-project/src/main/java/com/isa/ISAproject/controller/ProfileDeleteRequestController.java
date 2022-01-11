package com.isa.ISAproject.controller;

import java.util.List;

import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.ProfileDeleteRequestDTO;
import com.isa.ISAproject.dto.RegistrationRequestDTO;
import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.exception.ResourceConflictException;
import com.isa.ISAproject.model.ProfileDeleteRequest;
import com.isa.ISAproject.model.RegistrationRequest;
import com.isa.ISAproject.model.User;
import com.isa.ISAproject.repository.ProfileDeleteRequestRepository;
import com.isa.ISAproject.repository.UserRepository;
import com.isa.ISAproject.service.EmailService;
import com.isa.ISAproject.service.ProfileDeleteRequestService;

@CrossOrigin("*")
@RestController
public class ProfileDeleteRequestController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private ProfileDeleteRequestRepository profileDeleteRequestRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProfileDeleteRequestService profileDeleteRequestService;
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value="/api/instructors/profileDeleteRequest",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('INSTRUCTOR')")
	public ResponseEntity<?> sendProfifleDeleteRequest(@RequestBody ProfileDeleteRequestDTO dto){
	
		ProfileDeleteRequestDTO req=profileDeleteRequestService.sendProfileDeleteRequest(dto);
		return new ResponseEntity<>(req,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="api/admin/allProfileDeleteRequests",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SYSADMIN') || hasRole('ADMIN')")
	public ResponseEntity<List<ProfileDeleteRequestDTO>> getUnverifiedRegistrationRequests(){
		List<ProfileDeleteRequestDTO> dtos=profileDeleteRequestService.findAllUnverified();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/acceptProfileDeleteRequest",method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<UserDTO> acceptProfileDeleteRequest(@RequestBody ProfileDeleteRequestDTO dto){
		
		
		try {
			profileDeleteRequestService.acceptDeleteRequest(dto);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(dto.getUserDTO(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<>(dto.getUserDTO(),HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/rejectProfileDeleteRequest",method = RequestMethod.PUT,params= {"message"},consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> rejectProfileDeleteRequest(@RequestBody ProfileDeleteRequestDTO dto,@RequestParam String message){

		try {
			profileDeleteRequestService.rejectDeleteRequest(dto,message);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<>(dto.getUserDTO(),HttpStatus.OK);	
		
		
	}
	
	@RequestMapping(value="/api/cottageOwners/profileDeleteRequest",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<?> sendProfifleDeleteRequestCottageOwner(@RequestBody ProfileDeleteRequestDTO dto){
	
		ProfileDeleteRequestDTO req=profileDeleteRequestService.sendProfileDeleteRequest(dto);
		return new ResponseEntity<>(req,HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/boatOwners/profileDeleteRequest",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('BOAT_OWNER')")
	public ResponseEntity<?> sendProfifleDeleteRequestBoatOwner(@RequestBody ProfileDeleteRequestDTO dto){
	
		ProfileDeleteRequestDTO req=profileDeleteRequestService.sendProfileDeleteRequest(dto);
		return new ResponseEntity<>(req,HttpStatus.OK);
	}
	
}
