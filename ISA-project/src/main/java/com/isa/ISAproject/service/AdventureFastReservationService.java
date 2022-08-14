package com.isa.ISAproject.service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.PessimisticLockException;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.EditAdventureFastReservationDTO;
import com.isa.ISAproject.dto.ReserveAdventureFastResrvationDTO;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.AdventureFastReservationMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureFastReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.model.TimePeriod;
import com.isa.ISAproject.model.UnavailabilityType;
import com.isa.ISAproject.repository.AdventureFastReservationRepository;
import com.isa.ISAproject.repository.AdventureRepository;
import com.isa.ISAproject.repository.InstructorRepository;
import com.isa.ISAproject.repository.TimePeriodRepository;

@Service
public class AdventureFastReservationService {
	
	@Autowired
	private AdventureFastReservationRepository adventureFastReservationRepository;
	
	@Autowired
	private AdventureRepository adventureRepository;
	@Autowired
	private TimePeriodService timePeriodService;
	@Autowired 
	private EmailService emailService;
	@Autowired
	private InstructorRepository instructorRepository;

	@Autowired
	private TimePeriodRepository timePeriodRepository;

	public void delite(AdventureFastReservation a) {
		this.adventureFastReservationRepository.delete(a);
	}
	public AdventureFastReservation findById(Long id) {
		Optional<AdventureFastReservation> OPt=this.adventureFastReservationRepository.findById(id);
		if (!OPt.isPresent()) {
			return null;
		} 
		AdventureFastReservation res=OPt.get();
		return res;
	}
	public List<AdventureFastReservationDTO> getFastReservationsByInstructor(Long id){
		
		List<AdventureFastReservationDTO> res=new ArrayList<>();
		List<AdventureFastReservation> reservations=adventureFastReservationRepository.findAll();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		for (AdventureFastReservation a : reservations) {
			//za one akcije koje ne vaze vise treba izbirsati taj period iz nedostupnosti insturktora
			if( a.getValidityEnd().isBefore(LocalDate.now()) && a.getAdventure().getInstructor().getId()==id) {
				List<TimePeriodDTO> periods=timePeriodService.findUnavailabilityByInstructor(id);
				for (TimePeriodDTO t : periods) {
					LocalDateTime start = LocalDateTime.parse(t.getStart(),formatter);
					LocalDateTime end = LocalDateTime.parse(t.getEnd(),formatter);
					if(start.isEqual(a.getReservationStart()) && end.isEqual(a.getReservationEnd())) {
						timePeriodService.removeUnavailabilityInstructor(t, id);
						break;
					}
				}
			}
			if(a.getAdventure().getInstructor().getId()==id && a.getValidityEnd().isAfter(LocalDate.now()))
				res.add(AdventureFastReservationMapper.convertToDTO(a));
		}
		return res;
		
	}
	public List<AdventureFastReservationDTO> getFastReservationsByAdventure(Long id){
		
		List<AdventureFastReservationDTO> res=new ArrayList<>();
		List<AdventureFastReservation> reservations=adventureFastReservationRepository.findAll();
		
		for (AdventureFastReservation a : reservations) {
			if(a.getAdventure().getId()==id && a.getValidityEnd().isAfter(LocalDate.now()))
				res.add(AdventureFastReservationMapper.convertToDTO(a));
		
		}
		return res;
		
	}
	public List<AdventureFastReservationDTO> getFastReservationsByAdventureClient(Long id){
		
		List<AdventureFastReservationDTO> res=new ArrayList<>();
		List<AdventureFastReservation> reservations=adventureFastReservationRepository.findAll();
		
		for (AdventureFastReservation a : reservations) {
			if(a.getAdventure().getId()==id && a.getValidityEnd().isAfter(LocalDate.now()))
				res.add(AdventureFastReservationMapper.convertToDTO(a));
		
		}
		for (AdventureFastReservation adventureFastReservation : reservations) {
			for (AdventureFastReservationDTO dto : res) {
				if(adventureFastReservation.getId()==dto.getId()) {
					int startHour=adventureFastReservation.getReservationStart().getHour();
					int endHour=adventureFastReservation.getReservationEnd().getHour();
					int duration=endHour-startHour;
					dto.setDurationHours(duration);
				}
			}
		}
		return res;
		
	}
	
	@Transactional(readOnly=false)
	public AdventureFastReservationDTO addAdventureFastReservation(AdventureFastReservationDTO dto) throws PessimisticLockingFailureException, DateTimeException, PessimisticLockException, InterruptedException {
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
		time.setType(UnavailabilityType.Action);
		timePeriodService.setUnavailabilityInstructor(time, dto.getAdventure().getInstructor().getId());
		AdventureFastReservation fast=new AdventureFastReservation(dto.getId(),adventure,start,end,dto.getMaxPersons(),dto.getPrice(),start1,end1,items);
		adventureFastReservationRepository.save(fast);
		
		String message="There is new available action for adventure "+adventure.getName()+".Check this out on our website!";
		Set<Client> subscribers=adventure.getSubscribers();
		for (Client c : subscribers) {
			try {
				this.emailService.sendMessage(c.getEmail(), message);
			} catch (MailException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return AdventureFastReservationMapper.convertToDTO(fast);
	}
	
	public AdventureFastReservationDTO editAdventureFastReservation(EditAdventureFastReservationDTO dto) throws Exception {
		AdventureFastReservationDTO actionDTO=dto.getAction();
		TimePeriodDTO oldPeriod=dto.getOldReservationPeriod();
		AdventureFastReservation res=adventureFastReservationRepository.getById(actionDTO.getId());
		Adventure adventure=adventureRepository.getById(actionDTO.getAdventure().getId());
		Set<AdditionalItem> items=new HashSet<>();
		for (AdditionalItemDTO adto : actionDTO.getAdditionalItems()) {
			AdditionalItem a=AdditionalItemMapper.convertFromDTO(adto);
			items.add(a);
			
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(actionDTO.getReservationStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(actionDTO.getReservationEnd(),formatter);
		
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate start1 = LocalDate.parse(actionDTO.getValidityStart(),formatter1);
		LocalDate end1 = LocalDate.parse(actionDTO.getValidityEnd(),formatter1);
		
		/*Set<TimePeriod> unavailability=adventure.getInstructor().getUnavailability();
		for (TimePeriod t : unavailability) {
			if(t.getStart().isEqual(LocalDateTime.parse(oldPeriod.getStart(),formatter)) && t.getEnd().isEqual(LocalDateTime.parse(oldPeriod.getStart(),formatter))) 
				unavailability.remove(t);
		}
		instructorRepository.save(adventure.getInstructor());
		List<TimePeriod> times=timePeriodRepository.findAll();
		for (TimePeriod t : times) {
			if(t.getStart().isEqual(LocalDateTime.parse(oldPeriod.getStart(),formatter)) && t.getEnd().isEqual(LocalDateTime.parse(oldPeriod.getStart(),formatter))) 
				timePeriodRepository.delete(t);
		
		}*/
		timePeriodService.removeUnavailabilityInstructor(oldPeriod,(long) 1);
			
		
		TimePeriodDTO time=new TimePeriodDTO();
		time.setStart(actionDTO.getReservationStart());
		time.setEnd(actionDTO.getReservationEnd());
		time.setType(UnavailabilityType.Action);
		if(timePeriodService.setUnavailabilityInstructor(time, actionDTO.getAdventure().getInstructor().getId())==false)
			return null;
		
		res.setReservationStart(start);
		res.setReservationEnd(end);
		res.setValidityStart(start1);
		res.setValidityEnd(end1);
		res.setMaxPersons(actionDTO.getMaxPersons());
		res.setPrice(actionDTO.getPrice());
		res.setAdditionalItems(items);
		adventureFastReservationRepository.save(res);
		
		
		return AdventureFastReservationMapper.convertToDTO(res);
		//return oldPeriod;
	}
	public AdventureReservationDTO convertToAdventureReservation(ReserveAdventureFastResrvationDTO dto){
		AdventureReservationDTO res=new AdventureReservationDTO();
		res.setReservationStart(dto.getReservationStart());
		res.setReservationEnd(dto.getReservationEnd());
		res.setAdventure(dto.getAdventure());
		res.setClient(dto.getClient());
		res.setNumberOfPersons(dto.getMaxPersons());
		res.setAdditionalItems(dto.getAdditionalItems());
		return res;
	}
}
