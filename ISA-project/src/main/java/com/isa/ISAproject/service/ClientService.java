package com.isa.ISAproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	public Optional<Client> findById(Long id) {
		return this.clientRepository.findById(id);
	}
	public Client save(Client newClient) {
		return this.clientRepository.save(newClient);
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
	
	
}
