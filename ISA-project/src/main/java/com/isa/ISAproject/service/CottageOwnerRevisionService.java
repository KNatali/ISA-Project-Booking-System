package com.isa.ISAproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.CottageOwnerRevision;
import com.isa.ISAproject.model.CottageRevision;
import com.isa.ISAproject.repository.CottageOwnerRevisionRepository;
import com.isa.ISAproject.repository.CottageRevisionRepository;
import com.isa.ISAproject.repository.RevisionRepository;

@Service
public class CottageOwnerRevisionService {
	@Autowired
	private CottageOwnerRevisionRepository cottageOwnerRevisionRepository;
	
	public CottageOwnerRevision save(CottageOwnerRevision newRevision) {
		return this.cottageOwnerRevisionRepository.save(newRevision);
	}
}
