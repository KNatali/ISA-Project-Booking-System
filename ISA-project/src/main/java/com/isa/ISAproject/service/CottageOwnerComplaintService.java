package com.isa.ISAproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.CottageOwnerComplaint;
import com.isa.ISAproject.repository.CottageOwnerComplaintRepository;

@Service
public class CottageOwnerComplaintService {
	@Autowired
	private CottageOwnerComplaintRepository cottageOwnerComplaintRepository;
	
	public CottageOwnerComplaint save(CottageOwnerComplaint newCottageOwnerComplaint) {
		return this.cottageOwnerComplaintRepository.save(newCottageOwnerComplaint);
	}
}
