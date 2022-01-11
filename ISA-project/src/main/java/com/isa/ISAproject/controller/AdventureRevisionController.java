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

import com.isa.ISAproject.dto.AdventureRevisionDTO;
import com.isa.ISAproject.service.AdventureRevisionService;

@CrossOrigin("*")
@RestController
public class AdventureRevisionController {
	
	@Autowired
	private AdventureRevisionService adventureRevisionService;
	
	@RequestMapping(value="api/admin/allAdventureRevisions",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('SYSADMIN') || hasRole('ADMIN')")
	public ResponseEntity<List<AdventureRevisionDTO>> getAdventureRevisions(){
		List<AdventureRevisionDTO> dtos=adventureRevisionService.getAll();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	

}
