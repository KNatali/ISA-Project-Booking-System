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
import com.isa.ISAproject.dto.BoatFastReservationDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.dto.CottageFastReservationDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.dto.EditCottageFastReservationDTO;
import com.isa.ISAproject.dto.ReserveBoatFastResrvationDTO;
import com.isa.ISAproject.dto.ReserveCottageFastReservation;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.BoatFastReservationMapper;
import com.isa.ISAproject.mapper.CottageFastReservationMapper;
import com.isa.ISAproject.mapper.CottageMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.BoatFastReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.CottageFastReservation;
import com.isa.ISAproject.model.UnavailabilityType;
import com.isa.ISAproject.repository.CottageFastReservationRepository;
import com.isa.ISAproject.repository.CottageOwnerRepository;
import com.isa.ISAproject.repository.CottageRepository;
import com.isa.ISAproject.repository.TimePeriodRepository;

@Service
public class CottageFastReservationService {
	@Autowired
	private CottageFastReservationRepository cottageFastReservationRepository;
	@Autowired
	private CottageRepository cottageRepository;
	@Autowired
	private TimePeriodService timePeriodService;
	@Autowired 
	private EmailService emailService;
	@Autowired
	private CottageOwnerRepository cottageOwnerRepository;
	@Autowired
	private TimePeriodRepository timePeriodRepository;

	public List<CottageFastReservationDTO> getFastReservationsByCottageOwner(Long id){
		
		List<CottageFastReservationDTO> res=new ArrayList<>();
		List<CottageFastReservation> reservations=cottageFastReservationRepository.findAll();
		
		for (CottageFastReservation c : reservations) {
			//if(c.getCottage().getCottageOwner().getId()==id && c.getValidityEnd().isAfter(LocalDate.now()))
				//res.add(CottageFastReservationMapper.convertToDTO(c));
			
			CottageDTO cottage=CottageMapper.convertToDTO(c.getCottage());
			Set<AdditionalItemDTO> items=new HashSet<>();
			for (AdditionalItem i : c.getAdditionalItems()) {
				AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
				items.add(dto);
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			CottageFastReservationDTO ctfdto = new CottageFastReservationDTO(c.getId(), c.getReservationStart().format(formatter), c.getReservationEnd().format(formatter), c.getDuration(), c.getMaxPersons(), c.getPrice(), c.getValidityStart().format(formatter1), c.getValidityEnd().format(formatter1), cottage, items);
			res.add(ctfdto); 
			 
		}
		return res;
		
	}
	public CottageFastReservation findById(Long id) {
		Optional<CottageFastReservation> OPt=this.cottageFastReservationRepository.findById(id);
		if (!OPt.isPresent()) {
			return null;
		} 
		CottageFastReservation res=OPt.get();
		return res;
	}
	public void delite(CottageFastReservation a) {
		this.cottageFastReservationRepository.delete(a);
	}
	public List<CottageFastReservationDTO> getFastReservationsByCottageClient(Long id){
		
		List<CottageFastReservationDTO> res=new ArrayList<>();
		List<CottageFastReservation> reservations=cottageFastReservationRepository.findAll();
		
		for (CottageFastReservation a : reservations) {
			if(a.getCottage().getId()==id && a.getValidityEnd().isAfter(LocalDate.now()))
				res.add(CottageFastReservationMapper.convertToDTO(a));
		
		}
		for (CottageFastReservation cottageFastReservation : reservations) {
			for (CottageFastReservationDTO dto : res) {
				if(cottageFastReservation.getId()==dto.getId()) {
					int startDay=cottageFastReservation.getReservationStart().getDayOfYear();
					int endDay=cottageFastReservation.getReservationEnd().getDayOfYear();
					int duration=endDay-startDay;
					dto.setDuration(duration);
				}
			}
		}
		return res;
		
	}
	public List<CottageFastReservationDTO> getFastReservationsByCottage(Long id){
		
		List<CottageFastReservationDTO> res=new ArrayList<>();
		List<CottageFastReservation> reservations=cottageFastReservationRepository.findAll();
		
		for (CottageFastReservation c : reservations) {
			//if(c.getCottage().getCottageOwner().getId()==id && c.getValidityEnd().isAfter(LocalDate.now()))
				//res.add(CottageFastReservationMapper.convertToDTO(c));
			CottageDTO cottage=CottageMapper.convertToDTO(c.getCottage());
			Set<AdditionalItemDTO> items=new HashSet<>();
			for (AdditionalItem i : c.getAdditionalItems()) {
				AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
				items.add(dto);
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			CottageFastReservationDTO ctfdto = new CottageFastReservationDTO(c.getId(), c.getReservationStart().format(formatter), c.getReservationEnd().format(formatter), c.getDuration(), c.getMaxPersons(), c.getPrice(), c.getValidityStart().format(formatter1), c.getValidityEnd().format(formatter1), cottage, items);
			res.add(ctfdto); 
		}
		return res;
		
	}
	
	@Transactional(readOnly=false)
	public CottageFastReservationDTO addCottageFastReservation(CottageFastReservationDTO dto) throws PessimisticLockingFailureException, DateTimeException  {
		Cottage cottage=cottageRepository.getById(dto.getCottage().getId());
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
		timePeriodService.setUnavailabilityCottage(time, dto.getCottage().getId());
		
		
		CottageFastReservation fast=new CottageFastReservation(dto.getId(),cottage,start,end,dto.getMaxPersons(),dto.getPrice(),start1,end1,items);
		cottageFastReservationRepository.save(fast);
		
		String message="There is new available action for cottage "+cottage.getName()+".Check this out on our website!";
		Set<Client> subscribers=cottage.getSubscribers();
		for (Client c : subscribers) {
			try {
				this.emailService.sendMessage(c.getEmail(), message);
			} catch (MailException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		CottageDTO cottageDTO=CottageMapper.convertToDTO(fast.getCottage());
		CottageFastReservationDTO ctfdto = new CottageFastReservationDTO(fast.getId(), fast.getReservationStart().format(formatter), fast.getReservationEnd().format(formatter), fast.getDuration(), fast.getMaxPersons(), fast.getPrice(), fast.getValidityStart().format(formatter1), fast.getValidityEnd().format(formatter1), cottageDTO, dto.getAdditionalItems());
		
		//return CottageFastReservationMapper.convertToDTO(fast);
		return ctfdto;
	}
	
	public CottageFastReservationDTO editCottageFastReservation(EditCottageFastReservationDTO dto) throws Exception {
		CottageFastReservationDTO actionDTO=dto.getAction();
		TimePeriodDTO oldPeriod=dto.getOldReservationPeriod();
		CottageFastReservation res=cottageFastReservationRepository.getById(actionDTO.getId());
		Cottage cottage=cottageRepository.getById(actionDTO.getCottage().getId());
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
		
		timePeriodService.removeUnavailabilityCottage(oldPeriod,(long) 1);
		
		TimePeriodDTO time=new TimePeriodDTO();
		time.setStart(actionDTO.getReservationStart());
		time.setEnd(actionDTO.getReservationEnd());
		time.setType(UnavailabilityType.Action);
		if(timePeriodService.setUnavailabilityCottage(time, actionDTO.getCottage().getCottageOwner().getId())==false)
			return null;
		
		res.setReservationStart(start);
		res.setReservationEnd(end);
		res.setValidityStart(start1);
		res.setValidityEnd(end1);
		res.setMaxPersons(actionDTO.getMaxPersons());
		res.setPrice(actionDTO.getPrice());
		res.setAdditionalItems(items);
		cottageFastReservationRepository.save(res);
		
		
		return CottageFastReservationMapper.convertToDTO(res);
	}
	public CottageReservationDTO convertToCottageReservationDTO(ReserveCottageFastReservation dto){
		CottageReservationDTO res=new CottageReservationDTO();
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
		
		res.setCottage(dto.getCottage());
		res.setClient(dto.getClient());
		res.setMaxPersons(dto.getMaxPersons());
		res.setAdditionalItems(dto.getAdditionalItems());
		return res;
	}
}
