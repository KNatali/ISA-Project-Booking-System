package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.repository.BoatReservationRepository;

@Service
public class BoatReservationService {
	@Autowired
	private BoatReservationRepository boatReservationRepository;
	
	public List<BoatReservation> findAll() {
		return this.boatReservationRepository.findAll();
	}
	public List<BoatReservation> findAllResByIdClient(Long id){
		List<BoatReservation> res=new ArrayList<>();
		List<BoatReservation> all=this.findAll();
		for (BoatReservation boatres : all) {
			if(boatres.getClient().getId().equals(id)) {
				res.add(boatres);
			}
		}
		return res;
	}
}
