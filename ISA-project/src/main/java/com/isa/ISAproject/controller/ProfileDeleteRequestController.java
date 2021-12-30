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
	public ResponseEntity<List<ProfileDeleteRequestDTO>> getAllRegistrationRequests(){
		List<ProfileDeleteRequestDTO> dtos=profileDeleteRequestService.findAll();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/acceptProfileDeleteRequest",method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<UserDTO> acceptProfileDeleteRequest(@RequestBody ProfileDeleteRequestDTO dto){
		profileDeleteRequestService.acceptDeleteRequest(dto);
	
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendMessage(dto.getUserDTO().getEmail(),"Your profile delete request has been accepted. Your account has been deleted and you can not log in!");
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}
		
		if(dto.getUserDTO()==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<>(dto.getUserDTO(),HttpStatus.OK);
	}
	
}
