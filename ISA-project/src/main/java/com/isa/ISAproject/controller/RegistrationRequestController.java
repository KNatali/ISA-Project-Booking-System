package com.isa.ISAproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.EmailMessageDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.dto.PasswordChangeDTO;
import com.isa.ISAproject.dto.RegistrationRequestDTO;
import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.service.EmailService;
import com.isa.ISAproject.service.RegistrationRequestService;

@CrossOrigin("*")
@RestController
public class RegistrationRequestController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private RegistrationRequestService registratinRequestService;
	@Autowired
	private EmailService emailService;

	@RequestMapping(value="api/admin/allRegistrationRequests",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<List<RegistrationRequestDTO>> getAllRegistrationRequests(){
		List<RegistrationRequestDTO> dtos=registratinRequestService.findAll();
		
	
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/acceptRegistrationRequest",method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<UserDTO> acceptRegistrationRequest(@RequestBody RegistrationRequestDTO dto){
		registratinRequestService.activate(dto);
	
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendAcceptRegistrationMessage(dto.getUserDTO().getEmail());
		}catch( Exception e ){
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
			Thread.currentThread().interrupt();
		}
		if(dto.getUserDTO()==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(dto.getUserDTO(),HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/rejectRegistrationRequest",method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> rejectRegistrationRequest(@RequestBody RegistrationRequestDTO dto){

		registratinRequestService.reject(dto);
		if(dto.getUserDTO()==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(dto.getUserDTO(),HttpStatus.OK);
	}

}
