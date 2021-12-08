package com.isa.ISAproject.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.Boat;
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
	public List<BoatReservation> sortByDate(Long id) {
		List<BoatReservation> reservations=this.findAllResByIdClient(id);
		List<BoatReservation> res=new ArrayList<>();
		List<BoatReservation> sorted=this.boatReservationRepository.findByOrderByDateDesc();
		for (BoatReservation boatReservation : sorted) {
			for (BoatReservation Reservation2 : reservations) {
				if(boatReservation.getId().equals(Reservation2.getId())) {
					res.add(boatReservation);
				}
			}
		}
		return res;
	}
	public List<BoatReservation> sortByDuration(Long id) {
		List<BoatReservation> reservations=this.findAllResByIdClient(id);
		List<BoatReservation> res=new ArrayList<>();
		List<BoatReservation> sorted=this.boatReservationRepository.findByOrderByDurationDesc();
		for (BoatReservation boatReservation : sorted) {
			for (BoatReservation boatReservation2 : reservations) {
				if(boatReservation.getId().equals(boatReservation2.getId())) {
					res.add(boatReservation);
				}
			}
		}
		return res;
	}
	public List<BoatReservation> sortByPrice(Long id) {
		List<BoatReservation> reservations=this.findAllResByIdClient(id);
		List<BoatReservation> res=new ArrayList<>();
		List<BoatReservation> sorted=this.boatReservationRepository.findByOrderByPriceDesc();
		for (BoatReservation boatRes : sorted) {
			for (BoatReservation boatReservation2 : reservations) {
				if(boatRes.getId().equals(boatReservation2.getId())) {
					res.add(boatRes);
				}
			}
		}
		return res;
	}
	/*public List<BoatReservation> activeReservation(Long id){
		List<BoatReservation> allRes=this.findAllResByIdClient(id);
		List<BoatReservation> res=new ArrayList<>();
		LocalDateTime lt= LocalDateTime.now();
		for (BoatReservation boatReservation : allRes) {
			if(boatReservation.getDate().isAfter(lt)) {
				res.add(boatReservation);
			}
		}
		return res;
	}*/
}
