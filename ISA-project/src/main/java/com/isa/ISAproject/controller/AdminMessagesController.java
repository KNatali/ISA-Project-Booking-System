package com.isa.ISAproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.EmailMessageDTO;
import com.isa.ISAproject.dto.RegistrationRequestDTO;
import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.service.EmailService;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/admin/message")
public class AdminMessagesController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value="/registrationReject",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrationReject(@RequestBody EmailMessageDTO dto){

		//slanje emaila
		try {
			System.out.println("Thread id: " + Thread.currentThread().getId());
			emailService.sendAdminMessage(dto);
		}catch( Exception e ){
			Thread.currentThread().interrupt();
			logger.info("Greska prilikom slanja emaila: " + e.getMessage());
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
