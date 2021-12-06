package com.isa.ISAproject.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.repository.CottageReservationRepository;

@Service
public class CottageReservationService {
	@Autowired
	private CottageReservationRepository cottageReservationRepository;
	
	public List<CottageReservation> findAll() {
		return this.cottageReservationRepository.findAll();
	}
	public List<CottageReservation> sortByPrice(Long id) {
		List<CottageReservation> reservations=this.findAllResByIdClient(id);
		List<CottageReservation> res=new ArrayList<>();
		List<CottageReservation> sorted=this.cottageReservationRepository.findByOrderByPriceDesc();
		for (CottageReservation cottageReservation : sorted) {
			for (CottageReservation cottageReservation2 : reservations) {
				if(cottageReservation.getId().equals(cottageReservation2.getId())) {
					res.add(cottageReservation);
				}
			}
		}
		return res;
	}
	public List<CottageReservation> sortByDate(Long id) {
		List<CottageReservation> reservations=this.findAllResByIdClient(id);
		List<CottageReservation> res=new ArrayList<>();
		List<CottageReservation> sorted=this.cottageReservationRepository.findByOrderByDateDesc();
		for (CottageReservation cottageReservation : sorted) {
			for (CottageReservation cottageReservation2 : reservations) {
				if(cottageReservation.getId().equals(cottageReservation2.getId())) {
					res.add(cottageReservation);
				}
			}
		}
		return res;
	}
	public List<CottageReservation> sortByDuration(Long id) {
		List<CottageReservation> reservations=this.findAllResByIdClient(id);
		List<CottageReservation> res=new ArrayList<>();
		List<CottageReservation> sorted=this.cottageReservationRepository.findByOrderByDurationDesc();
		for (CottageReservation cottageReservation : sorted) {
			for (CottageReservation cottageReservation2 : reservations) {
				if(cottageReservation.getId().equals(cottageReservation2.getId())) {
					res.add(cottageReservation);
				}
			}
		}
		return res;
	}
	public List<CottageReservation> findAllResByIdClient(Long id){
		List<CottageReservation> res=new ArrayList<>();
		List<CottageReservation> all=this.findAll();
		for (CottageReservation cottageReservation : all) {
			if(cottageReservation.getClient().getId().equals(id)) {
				res.add(cottageReservation);
			}
		}
		return res;
	}
	public List<CottageReservation> activeReservation(Long id){
		List<CottageReservation> allRes=this.findAllResByIdClient(id);
		List<CottageReservation> res=new ArrayList<>();
		LocalDateTime lt= LocalDateTime.now();
		for (CottageReservation r : allRes) {
			if(r.getDate().isAfter(lt)) {
				res.add(r);
			}
		}
		return res;
	}
}
