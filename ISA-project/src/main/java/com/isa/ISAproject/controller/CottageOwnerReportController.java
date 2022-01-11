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

import com.isa.ISAproject.dto.CottageOwnerReportDTO;
import com.isa.ISAproject.service.CottageOwnerReportService;
import com.isa.ISAproject.service.EmailService;

@CrossOrigin("*")
@RestController
public class CottageOwnerReportController {
	@Autowired
	private CottageOwnerReportService cottageOwnerReportService;
	@Autowired
	private EmailService emailService;

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/api/cottageOwners/sendReservationReport",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('COTTAGE_OWNER')")
	public ResponseEntity<?> sendReservationReport(@RequestBody CottageOwnerReportDTO dto){
	
		CottageOwnerReportDTO req=cottageOwnerReportService.saveReservationReport(dto);
		return new ResponseEntity<>(req,HttpStatus.OK);
	}
}
