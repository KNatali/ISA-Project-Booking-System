package com.isa.ISAproject.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.repository.AdventureReservationRepository;

@Service
public class AdventureReservationService {
	@Autowired 
	private AdventureReservationRepository adventureReservationRepository;
	
	public List<AdventureReservation> findAll() {
		return this.adventureReservationRepository.findAll();
	}
	
	public List<AdventureReservation> findAllResByIdClient(Long id){
		List<AdventureReservation> res=new ArrayList<>();
		List<AdventureReservation> all=this.findAll();
		for (AdventureReservation adventureres : all) {
			if(adventureres.getClient().getId().equals(id)) {
				res.add(adventureres);
			}
		}
		return res;
	}
	public List<AdventureReservation> sortByDateStart(Long id) {
		List<AdventureReservation> reservations=this.findAllResByIdClient(id);
		List<AdventureReservation> res=new ArrayList<>();
		List<AdventureReservation> sorted=this.adventureReservationRepository.findByOrderByReservationStartDesc();
		for (AdventureReservation reservation1 : sorted) {
			for (AdventureReservation Reservation2 : reservations) {
				if(reservation1.getId().equals(Reservation2.getId())) {
					res.add(reservation1);
				}
			}
		}
		return res;
	}
	public List<AdventureReservation> sortByPrice(Long id) {
		List<AdventureReservation> reservations=this.findAllResByIdClient(id);
		List<AdventureReservation> res=new ArrayList<>();
		List<AdventureReservation> sorted=this.adventureReservationRepository.findByOrderByPriceDesc();
		for (AdventureReservation adventureRes : sorted) {
			for (AdventureReservation Reservation2 : reservations) {
				if(adventureRes.getId().equals(Reservation2.getId())) {
					res.add(adventureRes);
				}
			}
		}
		return res;
	}
	public List<AdventureReservation> activeReservation(Long id){
		List<AdventureReservation> allRes=this.findAllResByIdClient(id);
		List<AdventureReservation> res=new ArrayList<>();
		LocalDateTime lt= LocalDateTime.now();
		for (AdventureReservation r : allRes) {
			if(r.getReservationStart().isAfter(lt)) {
				res.add(r);
			}
		}
		return res;
	}
}
