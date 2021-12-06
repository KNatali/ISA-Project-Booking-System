package com.isa.ISAproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.repository.CottageReservationRepository;

@Service
public class CottageReservationService {
	@Autowired
	private CottageReservationRepository cottageReservationRepository;
	
	public List<CottageReservation> findAll() {
		return this.cottageReservationRepository.findAll();
	}
	public List<CottageReservation> sortByPrice() {
		return this.cottageReservationRepository.findByOrderByPriceDesc();
	}
	public List<CottageReservation> sortByDate() {
		return this.cottageReservationRepository.findByOrderByDateDesc();
	}
	public List<CottageReservation> sortByDuration() {
		return this.cottageReservationRepository.findByOrderByDurationDesc();
	}
}
