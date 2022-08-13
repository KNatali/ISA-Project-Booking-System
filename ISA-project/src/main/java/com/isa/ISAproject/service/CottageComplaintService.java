package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.BoatComplaintDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.CottageComplaintDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.mapper.BoatReservationMapper;
import com.isa.ISAproject.mapper.CottageReservationMapper;
import com.isa.ISAproject.model.BoatComplaint;
import com.isa.ISAproject.model.ComplaintType;
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
