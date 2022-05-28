package com.isa.ISAproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.BoatComplaint;
import com.isa.ISAproject.repository.BoatComplaintRepository;

@Service
public class BoatComplaintService {
	
	@Autowired
	private BoatComplaintRepository boatComplaintRepository;
	
	public BoatComplaint save(BoatComplaint newBoatComplaint) {
		return this.boatComplaintRepository.save(newBoatComplaint);
	}
}
