package com.isa.ISAproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Authority;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.model.User;
import com.isa.ISAproject.service.AddressService;
import com.isa.ISAproject.service.AuthorityService;
import com.isa.ISAproject.service.ClientService;

@CrossOrigin("*")
@RestController
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AuthorityService authorityService;
	
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
	@RequestMapping(value="/confirm-registration-client/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	public void confirmRegistrationForClient(@PathVariable Long id) {
		//this.clientService.activateById(id);
		this.clientService.save(this.clientService.activateById(id));
	}
	/*
	@RequestMapping(value="api/clients",method = RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientProfileDTO> save(@RequestBody ClientProfileDTO newClientProfileDTO){
		Address address=new Address(newClientProfileDTO.getStreet(),newClientProfileDTO.getState(),newClientProfileDTO.getCity());
		Address newAddress=this.addressService.save(address);
		List<Authority> authorities=this.authorityService.findByName("ROLE_CLIENT");
		User user=new User(newClientProfileDTO.getUsername(), newClientProfileDTO.getPassword(), newClientProfileDTO.getEmail(),newClientProfileDTO.getFirstName(),newClientProfileDTO.getLastName(),newAddress,newClientProfileDTO.getMobile(),true,"Client",authorities);
		//Client client=new Client(newClientProfileDTO.getId(),newClientProfileDTO.getUsername(), newClientProfileDTO.getPassword(), newClientProfileDTO.getEmail(),newClientProfileDTO.getFirstName(),newClientProfileDTO.getLastName(),newAddress,newClientProfileDTO.getMobile(),true,'Client');
		User newUser=this.
		return new ResponseEntity<>(new ItemDTO(savedItem),HttpStatus.CREATED);
	}*/
	@RequestMapping(value="api/clients/{id}",method = RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<ClientProfileDTO> update(@RequestBody ClientProfileDTO clientDTO,@PathVariable Long id){
		
		Client updatedClient=this.clientService.update(clientDTO);
		
		return new ResponseEntity<>(new ClientProfileDTO(updatedClient),HttpStatus.OK);
	}
	@RequestMapping(value="api/clients/change-password/{id}",method = RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<ClientProfileDTO> changePassword(@RequestBody ClientProfileDTO clientDTO,@PathVariable Long id){
		
		Client client = this.clientService.changePassword(clientDTO);
		
		return new ResponseEntity<>(new ClientProfileDTO(client),HttpStatus.OK);
	}
	/*
	@RequestMapping(value="api/clients/change-password",method = RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('CLIENT')")
	public ResponseEntity<Client> changePassword(@RequestBody ClientProfileDTO clientDTO){
		Client client=new Client();
		client = this.clientService.changePassword(clientDTO.getPassword(), clientDTO.getId());
		return new ResponseEntity<>(client,HttpStatus.OK);
	}*/



}
