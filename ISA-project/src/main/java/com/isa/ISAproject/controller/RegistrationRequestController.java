package com.isa.ISAproject.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.dto.PasswordChangeDTO;
import com.isa.ISAproject.dto.RegistrationRequestDTO;
import com.isa.ISAproject.dto.UserDTO;
import com.isa.ISAproject.service.RegistrationRequestService;

@CrossOrigin("*")
@RestController
public class RegistrationRequestController {
	
	@Autowired
	private RegistrationRequestService registratinRequestService;

	@RequestMapping(value="api/admin/allRegistrationRequests",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<List<RegistrationRequestDTO>> getAllRegistrationRequests(){
		List<RegistrationRequestDTO> dtos=registratinRequestService.findAll();
		
	
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	@RequestMapping(value="api/admin/acceptRequest",method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ADMIN') || hasRole('SYSADMIN')")
	public ResponseEntity<UserDTO> activate(@RequestBody RegistrationRequestDTO dto){
		registratinRequestService.activate(dto);
		if(dto.getUserDTO()==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<>(dto.getUserDTO(),HttpStatus.OK);
	}

}
