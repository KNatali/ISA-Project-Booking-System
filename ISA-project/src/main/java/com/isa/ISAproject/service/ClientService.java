package com.isa.ISAproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.AddressRepository;
import com.isa.ISAproject.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AddressService addressService;
	
	public Optional<Client> findById(Long id) {
		return this.clientRepository.findById(id);
	}
	public Client save(Client newClient) {
		return this.clientRepository.save(newClient);
	}
	public Client update(ClientProfileDTO client) {
		Optional<Client> clientOpt=this.findById(client.getId());
		if(!clientOpt.isPresent()) {
			return null;
		}
		Client clientFound=clientOpt.get();
		clientFound.setFirstName(client.getFirstName());
		clientFound.setLastName(client.getLastName());
		clientFound.setMobile(client.getMobile());
		clientFound.setUsername(client.getUsername());
		Address address=new Address();
		address.setCity(client.getCity());
		address.setState(client.getState());
		address.setStreet(client.getStreet());
		this.addressService.save(address);
		clientFound.setAddress(address);
		return this.save(clientFound);	
	}
	
	public Client activateById(Long id) {
		Optional<Client> clientOpt=this.findById(id);
		if(!clientOpt.isPresent()) {
			return null;
		}
		Client client=clientOpt.get();
		client.setEnabled(true);
		return client;
	}
	public Client changePassword(ClientProfileDTO clientDTO) {
		Optional<Client> clientOpt=this.findById(clientDTO.getId());
		if(!clientOpt.isPresent()) {
			return null;
		}
		Client client=clientOpt.get();
		client.setPassword(passwordEncoder.encode(clientDTO.getPassword()));
		Client newClient=this.clientRepository.save(client);
		return newClient;
	}
	public void delete(Client client) {
		this.clientRepository.delete(client);
	}

	
}
