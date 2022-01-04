package com.isa.ISAproject.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.AdventureFastReservationMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureFastReservation;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.AdventureFastReservationRepository;
import com.isa.ISAproject.repository.AdventureRepository;
import com.isa.ISAproject.repository.InstructorRepository;

@Service
public class AdventureFastReservationService {
	
	@Autowired
	private AdventureFastReservationRepository adventureFastReservationRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private AdventureRepository adventureRepository;
	@Autowired
	private TimePeriodService timePeriodService;

	public List<AdventureFastReservationDTO> getFastReservations(Long id){
		
		List<AdventureFastReservationDTO> res=new ArrayList<>();
		List<AdventureFastReservation> reservations=adventureFastReservationRepository.findAll();
		
		for (AdventureFastReservation a : reservations) {
			if(a.getAdventure().getInstructor().getId()==id && a.getValidityEnd().isAfter(LocalDate.now()))
				res.add(AdventureFastReservationMapper.convertToDTO(a));
		}
		return res;
		
	}
	
	public AdventureFastReservationDTO addAdventureFastReservation(AdventureFastReservationDTO dto) {
		Adventure adventure=adventureRepository.getById(dto.getAdventure().getId());
		Set<AdditionalItem> items=new HashSet<>();
		for (AdditionalItemDTO adto : dto.getAdditionalItems()) {
			AdditionalItem a=AdditionalItemMapper.convertFromDTO(adto);
			items.add(a);
			
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getReservationStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getReservationEnd(),formatter);
		
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate start1 = LocalDate.parse(dto.getValidityStart(),formatter1);
		LocalDate end1 = LocalDate.parse(dto.getValidityEnd(),formatter1);
		
		TimePeriodDTO time=new TimePeriodDTO();
		time.setStart(dto.getReservationStart());
		time.setEnd(dto.getReservationEnd());
		if(timePeriodService.setUnavailabilityInstructor(time, dto.getAdventure().getInstructor().getId())==false)
			return null;
		
		
		AdventureFastReservation fast=new AdventureFastReservation(dto.getId(),adventure,start,end,dto.getMaxPersons(),dto.getPrice(),start1,end1,items);
		adventureFastReservationRepository.save(fast);
		return AdventureFastReservationMapper.convertToDTO(fast);
	}
}
