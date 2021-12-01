package com.isa.ISAproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
}
