package com.isa.ISAproject.service;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;

import javax.persistence.PessimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.AdventureFastReservationMapper;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.mapper.AdventureReservationMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureFastReservation;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.SystemEarnings;
import com.isa.ISAproject.model.UnavailabilityType;
import com.isa.ISAproject.repository.AdventureRepository;
import com.isa.ISAproject.repository.AdventureReservationRepository;
import com.isa.ISAproject.repository.ClientRepository;
import com.isa.ISAproject.repository.SystemEarningsRepository;

import javassist.NotFoundException;

@Service
public class AdventureReservationService {
	@Autowired 
	private AdventureReservationRepository adventureReservationRepository;
	@Autowired
	private AdventureRepository adventureRepository;
	@Autowired
	private TimePeriodService timePeriodService;
	@Autowired 
	private EmailService emailService;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private SystemEarningsRepository systemEarningsRepository;
	
	
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
	public Optional<AdventureReservation> findById(Long id) {
		return this.adventureReservationRepository.findById(id);
	}
	public List<AdventureReservation> sortByDateStart(Long id) {
		List<AdventureReservation> reservations=this.oldReservation(id);
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
		List<AdventureReservation> reservations=this.oldReservation(id);
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
	public List<AdventureReservation> oldReservation(Long id){
		List<AdventureReservation> allRes=this.findAllResByIdClient(id);
		List<AdventureReservation> res=new ArrayList<>();
		LocalDateTime lt= LocalDateTime.now();
		for (AdventureReservation r : allRes) {
			if(r.getReservationStart().isBefore(lt)) {
				res.add(r);
			}
		}
		return res;
	}
	
	@Transactional(readOnly = false)
	public AdventureReservationDTO addAdventureReservation(AdventureReservationDTO dto) throws PessimisticLockException, DateTimeException {
		Adventure adventure=adventureRepository.getById(dto.getAdventure().getId());
		Client client=clientRepository.getById(dto.getClient().getId());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getReservationStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getReservationEnd(),formatter);
		
		
		TimePeriodDTO time=new TimePeriodDTO();
		time.setStart(dto.getReservationStart());
		time.setEnd(dto.getReservationEnd());
		time.setType(UnavailabilityType.Reservation);
		
		timePeriodService.setUnavailabilityInstructor(time, dto.getAdventure().getInstructor().getId());
				
		
		
		long days = Duration.between(start, end).toDays();
		int price=(int) (adventure.getPrice()*days);
		Set<AdditionalItem> items=new HashSet<>();
		for (AdditionalItemDTO adto : dto.getAdditionalItems()) {
			AdditionalItem a=AdditionalItemMapper.convertFromDTO(adto);
			items.add(a);
			price+=a.getPrice();
			
		}
		double earning=SystemEarnings.percentage*price/100;
		AdventureReservation res=new AdventureReservation(dto.getId(),start,end,adventure,dto.getNumberOfPersons(),price,items,client,null,earning);
		res.setSystemEarning(earning);
		adventureReservationRepository.save(res);
		List<AdventureReservation> list=client.getAdventureReservations();
		list.add(res);
		clientRepository.save(client);
		
		String message="Instructor has been make reservation for you for adventure "+adventure.getName()+".Check this in your reservation list";
		
			try {
				this.emailService.sendMessage(client.getEmail(), message);
			} catch (MailException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		return AdventureReservationMapper.convertToDTO(res);
	}
}
