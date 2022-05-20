package com.isa.ISAproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.CottageComplaint;
import com.isa.ISAproject.repository.CottageComplaintRepository;

@Service
public class CottageComplaintService {
	@Autowired
	private CottageComplaintRepository cottageComplaintRepository;
	
	public CottageComplaint save(CottageComplaint newCottageComplaint ) {
		return this.cottageComplaintRepository.save(newCottageComplaint);
	}
}
