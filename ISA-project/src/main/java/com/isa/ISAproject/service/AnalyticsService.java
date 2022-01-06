package com.isa.ISAproject.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.model.AdventureReservation;

@Service
public class AnalyticsService {
	

	@Autowired
	private AdventureReservationService adventureReservationService;

	
	public Double getAdventureEarnings(TimePeriodDTO dto){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		List<AdventureReservation> list=this.adventureReservationService.findAll();
		
		double earnings=0;
		for (AdventureReservation a : list) {
			if(a.getReservationEnd().isAfter(start) && a.getReservationEnd().isBefore(end) )
				earnings+=a.getSystemEarning();
		}
		return earnings;
	}
}



