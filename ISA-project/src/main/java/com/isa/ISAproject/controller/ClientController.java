package com.isa.ISAproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.service.ClientService;

@CrossOrigin("*")
@RestController
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="api/clients/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<ClientProfileDTO> getById(@PathVariable Long id){
		Optional<Client> item=clientService.findById(id);
		
		if(!item.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		ClientProfileDTO itemDto=new ClientProfileDTO(item.get());
		return new ResponseEntity<>(itemDto,HttpStatus.OK);
	}

}
