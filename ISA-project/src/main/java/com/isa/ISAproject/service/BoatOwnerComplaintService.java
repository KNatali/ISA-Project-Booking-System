package com.isa.ISAproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.BoatOwnerComplaint;
import com.isa.ISAproject.repository.BoatOwnerComplaintRepository;

@Service
public class BoatOwnerComplaintService {
	
	@Autowired
	private BoatOwnerComplaintRepository boatOwnerComplaintRepository;
	
	public BoatOwnerComplaint save(BoatOwnerComplaint newBoatOwnerComplaint) {
		return this.boatOwnerComplaintRepository.save(newBoatOwnerComplaint);
	}
}
