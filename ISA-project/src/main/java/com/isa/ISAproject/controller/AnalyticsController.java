package com.isa.ISAproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.service.AnalyticsService;

@CrossOrigin("*")
@RestController
public class AnalyticsController {

	
	@Autowired
	private AnalyticsService analyticsService;
	
	@RequestMapping(value="api/adventureReservation/periodEarnings",method = RequestMethod.POST,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public @ResponseBody Double getAdventureEarnings(@RequestBody TimePeriodDTO dto){
		
		return analyticsService.getAdventureEarnings(dto);
	}
}
