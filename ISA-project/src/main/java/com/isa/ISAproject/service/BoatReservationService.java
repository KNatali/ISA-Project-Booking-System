package com.isa.ISAproject.service;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.BoatReservationCreateDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.BoatReservationMapper;
import com.isa.ISAproject.mapper.CottageReservationMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.model.SystemEarnings;
import com.isa.ISAproject.model.UnavailabilityType;
import com.isa.ISAproject.repository.BoatRepository;
import com.isa.ISAproject.repository.BoatReservationRepository;
import com.isa.ISAproject.repository.ClientRepository;

@Service
public class BoatReservationService {
	@Autowired
	private BoatReservationRepository boatReservationRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private BoatRepository boatRepository;
	@Autowired
	private TimePeriodService timePeriodService;
	@Autowired 
	private EmailService emailService;
	@Autowired
	private BoatService boatService;
	
	public List<BoatReservation> findAll() {
		return this.boatReservationRepository.findAll();
	}
	public BoatReservation save(BoatReservation newRes){
		return this.boatReservationRepository.save(newRes);
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
	public List<BoatReservation> oldReservationForClinet(Long id){
		List<BoatReservation> allRes=this.findAllResByIdClient(id);
		List<BoatReservation> res=new ArrayList<>();
		LocalDateTime lt= LocalDateTime.now();
		for (BoatReservation boatReservation : allRes) {
			if(boatReservation.getReservationStart().isBefore(lt) && !boatReservation.isDeleted()) {
				res.add(boatReservation);
			}
		}
		return res;
	}
	public List<BoatReservation> sortByDate(Long id) {
		List<BoatReservation> reservations=this.oldReservationForClinet(id);
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
		List<BoatReservation> reservations=this.oldReservationForClinet(id);
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
		List<BoatReservation> reservations=this.oldReservationForClinet(id);
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
	public List<BoatReservation> activeReservation(Long id){
		List<BoatReservation> allRes=this.findAllResByIdClient(id);
		List<BoatReservation> res=new ArrayList<>();
		LocalDateTime lt= LocalDateTime.now();
		for (BoatReservation boatReservation : allRes) {
			if(boatReservation.getDate().isAfter(lt)  && !boatReservation.isDeleted()) {
				res.add(boatReservation);
			}
		}
		return res;
	}
	public BoatReservationDTO addBoatReservation(BoatReservationDTO dto) throws PessimisticLockingFailureException, DateTimeException {
		Boat boat=boatRepository.getById(dto.getBoat().getId());
		Client client=clientRepository.getById(dto.getClient().getId());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getReservationStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getReservationEnd(),formatter);
		
		
		TimePeriodDTO time=new TimePeriodDTO();
		time.setStart(dto.getReservationStart());
		time.setEnd(dto.getReservationEnd());
		time.setType(UnavailabilityType.Reservation);
		
		timePeriodService.setUnavailabilityBoatOwner(time, dto.getBoat().getId());
				
		long days = Duration.between(start, end).toDays();
		int price=(int) (boat.getPrice()*days*dto.getMaxPersons());
		Set<AdditionalItem> items=new HashSet<>();
		for (AdditionalItemDTO adto : dto.getAdditionalItems()) {
			AdditionalItem a=AdditionalItemMapper.convertFromDTO(adto);
			items.add(a);
			price+=a.getPrice();
			
		}
		double earning=SystemEarnings.percentage*price/100;
		BoatReservation res=new BoatReservation(dto.getId(),start,end,boat,dto.getMaxPersons(),price,items,client,null,earning);
		res.setDuration((int)days);
		res.setSystemEarning(earning);
		boatReservationRepository.save(res);
		List<BoatReservation> list=client.getBoatReservations();
		list.add(res);
		clientRepository.save(client);
		
		String message="Boat owner has been make reservation for you for boat "+boat.getName()+".Check this in your reservation list";
		
			try {
				this.emailService.sendMessage(client.getEmail(), message);
			} catch (MailException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		return BoatReservationMapper.convertToDTO(res);
	}
	public Optional<BoatReservation> findById(Long id) {
		return this.boatReservationRepository.findById(id);
	}
	public BoatReservationDTO  addBoatReservationClient(BoatReservationCreateDTO dto) {
		Optional<Client> clientOpt=this.clientRepository.findById(dto.getClientId());
		if(!clientOpt.isPresent()) {
			return null;
		}
		Client client=clientOpt.get();///////client
		
		Optional<Boat> boatOpt=this.boatRepository.findById(dto.getBoatId());
		if(!boatOpt.isPresent()) {
			return null;
		}
		Boat boat=boatOpt.get();////boat
		
		BoatReservation boatReservation=new BoatReservation();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getReservationStart(),formatter);
		LocalDateTime end = start.plusDays(dto.getNumberOfDays());
		
		boatReservation.setReservationStart(start);
		boatReservation.setReservationEnd(end);
		boatReservation.setBoat(boat);
		boatReservation.setClient(client);
		
		Set<AdditionalItem> items=new HashSet<>();
		int price=(int) (boat.getPrice()*dto.getNumberOfDays()*dto.getNumberOfPersons());
		for (AdditionalItemDTO adto : dto.getAdditionalItems()) {
			AdditionalItem a=AdditionalItemMapper.convertFromDTO(adto);
			items.add(a);
			price+=a.getPrice();		
		}
		boatReservation.setAdditionalItems(items);
		boatReservation.setSystemEarning(price);
		boatReservation.setPrice(price);
		boatReservation.setMaxPersons(dto.getNumberOfPersons());
		//dodato
		boat.setCapacity(boat.getCapacity()-boatReservation.getMaxPersons());
		boatRepository.save(boat);
		
		int day_start=start.getDayOfYear();
		int day_end=end.getDayOfYear();
		
		int duration=day_end-day_start;
		boatReservation.setDuration(duration);
		BoatReservation saved=this.boatReservationRepository.save(boatReservation);
		
		String message="Yoe successufuly made reservation for boat "+boat.getName()+".Check this in your reservation list";
		
		try {
			this.emailService.sendMessage(client.getEmail(), message);
		} catch (MailException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return BoatReservationMapper.convertToDTO(saved);
	}
	public BoatReservation deleteReservation(Long id) {
		Optional<BoatReservation> opt =this.findById(id);
		if(!opt.isPresent()) {
			return null;
		}
		BoatReservation found=opt.get();
		found.setDeleted(true);
		//treba obrisati zauzetosti za tu avanturu
		found.getBoat().setUnavailability(null);
		found.setAdditionalItems(null);
		BoatReservation saved=this.boatReservationRepository.save(found);
		return saved;
	}
}
