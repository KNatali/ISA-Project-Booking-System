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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.BoatFastReservationDTO;
import com.isa.ISAproject.dto.BoatReservationCreateDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.CottageReservationClientDTO;
import com.isa.ISAproject.dto.EditBoatFastReservationDTO;
import com.isa.ISAproject.dto.ReserveAdventureFastResrvationDTO;
import com.isa.ISAproject.dto.ReserveBoatFastResrvationDTO;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.AdventureFastReservationMapper;
import com.isa.ISAproject.mapper.BoatFastReservationMapper;
import com.isa.ISAproject.mapper.BoatMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.AdventureFastReservation;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.BoatFastReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.UnavailabilityType;
import com.isa.ISAproject.repository.BoatFastReservationRepository;
import com.isa.ISAproject.repository.BoatOwnerRepository;
import com.isa.ISAproject.repository.BoatRepository;
import com.isa.ISAproject.repository.TimePeriodRepository;

@Service
public class BoatFastReservationService {
	@Autowired
	private BoatFastReservationRepository boatFastReservationRepository;
	@Autowired
	private BoatRepository boatRepository;
	@Autowired
	private TimePeriodService timePeriodService;
	@Autowired 
	private EmailService emailService;
	@Autowired
	private BoatOwnerRepository boatOwnerRepository;
	@Autowired
	private TimePeriodRepository timePeriodRepository;

	public List<BoatFastReservationDTO> getFastReservationsByBoatOwner(Long id){
		
		List<BoatFastReservationDTO> res=new ArrayList<>();
		List<BoatFastReservation> reservations=boatFastReservationRepository.findAll();
		
		for (BoatFastReservation b : reservations) {
			//if(c.getCottage().getCottageOwner().getId()==id && c.getValidityEnd().isAfter(LocalDate.now()))
				//res.add(CottageFastReservationMapper.convertToDTO(c));
			
			BoatDTO boat=BoatMapper.convertToDTO(b.getBoat());
			Set<AdditionalItemDTO> items=new HashSet<>();
			for (AdditionalItem i : b.getAdditionalItems()) {
				AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
				items.add(dto);
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			BoatFastReservationDTO btfdto = new BoatFastReservationDTO(b.getId(), b.getReservationStart().format(formatter), b.getReservationEnd().format(formatter), b.getDuration(), b.getMaxPersons(), b.getPrice(), b.getValidityStart().format(formatter1), b.getValidityEnd().format(formatter1), boat, items);
			res.add(btfdto); 
			 
		}
		return res;
		
	}
	public BoatFastReservation findById(Long id) {
		Optional<BoatFastReservation> OPt=this.boatFastReservationRepository.findById(id);
		if (!OPt.isPresent()) {
			return null;
		} 
		BoatFastReservation res=OPt.get();
		return res;
	}
	public void delite(BoatFastReservation a) {
		this.boatFastReservationRepository.delete(a);
	}
	public List<BoatFastReservationDTO> getFastReservationsByBoatClient(Long id){
		
		List<BoatFastReservationDTO> res=new ArrayList<>();
		List<BoatFastReservation> reservations=boatFastReservationRepository.findAll();
		
		for (BoatFastReservation a : reservations) {
			if(a.getBoat().getId().equals(id) && a.getValidityEnd().isAfter(LocalDate.now()))
				res.add(BoatFastReservationMapper.convertToDTO(a));
		
		}
		for (BoatFastReservation boatFastReservation : reservations) {
			for (BoatFastReservationDTO dto : res) {
				if(boatFastReservation.getId().equals(dto.getId())) {
					int startDay=boatFastReservation.getReservationStart().getDayOfYear();
					int endDay=boatFastReservation.getReservationEnd().getDayOfYear();
					int duration=endDay-startDay;
					dto.setDuration(duration);
				}
			}
		}
		return res;
		
	}
	public List<BoatFastReservationDTO> getFastReservationsByBoat(Long id){
		
		List<BoatFastReservationDTO> res=new ArrayList<>();
		List<BoatFastReservation> reservations=boatFastReservationRepository.findAll();
		
		for (BoatFastReservation b : reservations) {
			//if(c.getCottage().getCottageOwner().getId()==id && c.getValidityEnd().isAfter(LocalDate.now()))
				//res.add(CottageFastReservationMapper.convertToDTO(c));
			if(b.getBoat().getId().equals(id)) {
				BoatDTO boat=BoatMapper.convertToDTO(b.getBoat());
				Set<AdditionalItemDTO> items=new HashSet<>();
				for (AdditionalItem i : b.getAdditionalItems()) {
					AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
					items.add(dto);
				}
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

				BoatFastReservationDTO btfdto = new BoatFastReservationDTO(b.getId(), b.getReservationStart().format(formatter), b.getReservationEnd().format(formatter), b.getDuration(), b.getMaxPersons(), b.getPrice(), b.getValidityStart().format(formatter1), b.getValidityEnd().format(formatter1), boat, items);
				res.add(btfdto); 	
			}
			
		}
		return res;
		
	}
	
	@Transactional(readOnly=false)
	public BoatFastReservationDTO addBoatFastReservation(BoatFastReservationDTO dto) throws PessimisticLockingFailureException, DateTimeException  {
		Boat boat=boatRepository.getById(dto.getBoat().getId());
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
		timePeriodService.setUnavailabilityBoatOwner(time, dto.getBoat().getBoatOwner().getId());
		
		
		BoatFastReservation fast=new BoatFastReservation(dto.getId(),boat,start,end,dto.getMaxPersons(),dto.getPrice(),start1,end1,items);
		boatFastReservationRepository.save(fast);
		
		String message="There is new available action for boat "+boat.getName()+".Check this out on our website!";
		Set<Client> subscribers=boat.getSubscribers();
		for (Client c : subscribers) {
			try {
				this.emailService.sendMessage(c.getEmail(), message);
			} catch (MailException e) {
				//e.printStackTrace();
			} catch (InterruptedException e) {
				  Thread.currentThread().interrupt();
			}
		}
		BoatDTO boatDTO=BoatMapper.convertToDTO(fast.getBoat());
		BoatFastReservationDTO btfdto = new BoatFastReservationDTO(fast.getId(), fast.getReservationStart().format(formatter), fast.getReservationEnd().format(formatter), fast.getDuration(), fast.getMaxPersons(), fast.getPrice(), fast.getValidityStart().format(formatter1), fast.getValidityEnd().format(formatter1), boatDTO, dto.getAdditionalItems());
		
		//return CottageFastReservationMapper.convertToDTO(fast);
		return btfdto;
	}
	
	public BoatFastReservationDTO editBoatFastReservation(EditBoatFastReservationDTO dto) throws Exception {
		BoatFastReservationDTO actionDTO=dto.getAction();
		TimePeriodDTO oldPeriod=dto.getOldReservationPeriod();
		BoatFastReservation res=boatFastReservationRepository.getById(actionDTO.getId());
		Boat boat=boatRepository.getById(actionDTO.getBoat().getId());
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
		
		timePeriodService.removeUnavailabilityBoatOwner(oldPeriod,(long) 1);
		
		TimePeriodDTO time=new TimePeriodDTO();
		time.setStart(actionDTO.getReservationStart());
		time.setEnd(actionDTO.getReservationEnd());
		time.setType(UnavailabilityType.Action);
		if(timePeriodService.setUnavailabilityBoatOwner(time, actionDTO.getBoat().getBoatOwner().getId())==false)
			return null;
		
		res.setReservationStart(start);
		res.setReservationEnd(end);
		res.setValidityStart(start1);
		res.setValidityEnd(end1);
		res.setMaxPersons(actionDTO.getMaxPersons());
		res.setPrice(actionDTO.getPrice());
		res.setAdditionalItems(items);
		boatFastReservationRepository.save(res);
		
		
		return BoatFastReservationMapper.convertToDTO(res);
	}
	public BoatReservationCreateDTO convertToBoatReservationCreateDTO(BoatReservationDTO dto){
		BoatReservationCreateDTO res=new BoatReservationCreateDTO();
		res.setReservationStart(dto.getReservationStart());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getReservationStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getReservationEnd(),formatter);
		int startDay=start.getDayOfYear();
		int endDay=end.getDayOfYear();
		int duration=endDay-startDay;
		res.setNumberOfDays(duration);
		
		res.setBoatId(dto.getBoat().getId());
		res.setClientId(dto.getClient().getId());
		res.setNumberOfPersons(dto.getMaxPersons());
		res.setAdditionalItems(dto.getAdditionalItems());
		
		return res;
	}
	public BoatReservationDTO convertToBoatReservationDTO(ReserveBoatFastResrvationDTO dto){
		BoatReservationDTO res=new BoatReservationDTO();
		res.setReservationStart(dto.getReservationStart());
		res.setReservationEnd(dto.getReservationEnd());
		
		//treba ispuniti i duratino
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getReservationStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getReservationEnd(),formatter);
		int startDay=start.getDayOfYear();
		int endDay=end.getDayOfYear();
		int duration=endDay-startDay;
		res.setDuration(duration);
		
		res.setBoat(dto.getBoat());
		res.setClient(dto.getClient());
		res.setMaxPersons(dto.getMaxPersons());
		res.setAdditionalItems(dto.getAdditionalItems());
		return res;
	}
}
