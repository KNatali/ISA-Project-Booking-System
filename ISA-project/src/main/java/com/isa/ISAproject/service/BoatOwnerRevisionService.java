package com.isa.ISAproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.BoatOwnerRevision;
import com.isa.ISAproject.model.BoatRevision;
import com.isa.ISAproject.repository.BoatOwnerRevisionRepository;

@Service
public class BoatOwnerRevisionService {
	@Autowired
	private BoatOwnerRevisionRepository boatOwnerRevisionRepository;
	
	public BoatOwnerRevision save(BoatOwnerRevision newRevision) {
		return this.boatOwnerRevisionRepository.save(newRevision);
	}

}
