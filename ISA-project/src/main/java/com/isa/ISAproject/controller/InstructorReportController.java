package com.isa.ISAproject.controller;

import java.util.List;

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
import com.isa.ISAproject.service.InstructorReportService;

@CrossOrigin("*")
@RestController
public class InstructorReportController {
	
	@Autowired
	private InstructorReportService instructorReportService;
	
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

}
