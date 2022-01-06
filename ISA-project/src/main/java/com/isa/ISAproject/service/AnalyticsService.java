package com.isa.ISAproject.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.mapper.AdventureReservationMapper;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.AdventureReservationRepository;

@Service
public class AnalyticsService {
	

	@Autowired
	private AdventureReservationService adventureReservationService;
	@Autowired
	private InstructorService instructorService;
	@Autowired
	private AdventureReservationRepository adventureReservationRepository;


	
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
	public Double getInstructorEarnings(TimePeriodDTO dto,Long id){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		
		List<AdventureReservation> temp=new ArrayList<>();
		List<AdventureReservation> reservations=adventureReservationRepository.findAll();
		for (AdventureReservation a : reservations) {
			if(a.getAdventure().getInstructor().getId()==id)
				temp.add(a);
		}
		
		
		double earnings=0;
		for (AdventureReservation a : temp) {
			if(a.getReservationEnd().isAfter(start) && a.getReservationEnd().isBefore(end) )
				earnings+=(a.getPrice()-a.getSystemEarning());
		}
		return earnings;
	}
	
	public List<AdventureReservationDTO> getInstructorReservations(Long id){
		List<AdventureReservationDTO> res=new ArrayList<>();
		List<AdventureReservation> temp=new ArrayList<>();
		List<AdventureReservation> reservations=adventureReservationRepository.findAll();
		for (AdventureReservation a : reservations) {
			if(a.getAdventure().getInstructor().getId()==id)
				temp.add(a);
		}
		for (AdventureReservation a : temp) {
			res.add(AdventureReservationMapper.convertToDTO(a));
		}
		return res;
		
	}
	

	
	public Double instructrAverageGrade(Long id) {
		Optional<Instructor> itemOptionals=this.instructorService.findById(id);
		Instructor instructor=itemOptionals.get();
		Set<Adventure> adventures=instructor.getAdventures();
		double grade=0;
		int count=0;
		double averageGrade=0;
			
		for(Adventure a:adventures) {
			if(a.getAverageGrade()!=0) {
				grade+=a.getAverageGrade();
				count++;
			}
		}
		averageGrade=grade/count;
		return averageGrade;
	}
}



