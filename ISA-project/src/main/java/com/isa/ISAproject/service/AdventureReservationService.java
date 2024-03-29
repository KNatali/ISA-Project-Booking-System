package com.isa.ISAproject.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;

import javax.persistence.PessimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureReservationCreateDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.AdventureReservationMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.SystemEarnings;
import com.isa.ISAproject.model.TimePeriod;
import com.isa.ISAproject.model.UnavailabilityType;
import com.isa.ISAproject.repository.AdventureRepository;
import com.isa.ISAproject.repository.AdventureReservationRepository;
import com.isa.ISAproject.repository.ClientRepository;


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
	private AdventureService adventureService;
	
	@Autowired
	private ClientService clientService;
	
	public List<AdventureReservation> findAll() {
		return this.adventureReservationRepository.findAll();
	}
	public AdventureReservation save(AdventureReservation  newAdventureReservation) {
		return this.adventureReservationRepository.save(newAdventureReservation);
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
			if(r.getReservationStart().isAfter(lt) && !r.isDeleted()) {
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
			if(r.getReservationStart().isBefore(lt) && !r.isDeleted()) {
				res.add(r);
			}
		}
		return res;
	}
	
	@Transactional(readOnly = false)
	public AdventureReservationDTO addAdventureReservation(AdventureReservationDTO dto) throws PessimisticLockException, InterruptedException {
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
		
		//samo dodati jos zauzetost za avanturu, client
		TimePeriod period=new TimePeriod(null, start, end, UnavailabilityType.Reservation);
		adventure.getUnavailability().add(period);
		this.adventureRepository.save(adventure);
				
		//long days = Duration.between(start, end).toDays();
		long hours = Duration.between(start, end).toHours();
		int price=(int) (adventure.getPrice()*hours*dto.getNumberOfPersons());
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
				//e.printStackTrace();
			} catch (InterruptedException e) {
				 Thread.currentThread().interrupt();
			}
		
		return AdventureReservationMapper.convertToDTO(res);
	}
	public AdventureReservation findByClientAndAdventure(Client client,Adventure adv) {
		List<AdventureReservation> all=this.adventureReservationRepository.findAll();
		for (AdventureReservation adventureReservation : all) {
			if(adventureReservation.getClient()==client && adventureReservation.getAdventure()==adv) {
				return adventureReservation;
			}
		}
		return null;
	}
	public AdventureReservationDTO convertFromAdventureReservationCreateDTO(AdventureReservationCreateDTO dto) {
		AdventureReservationDTO adventureReservationDTO=new AdventureReservationDTO();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getReservationStart(),formatter);
		//number od days je u slucaju avanture sat
		LocalDateTime end = start.plusHours(dto.getNumberOfDays());
		
		adventureReservationDTO.setReservationStart(start.toString());
		adventureReservationDTO.setReservationEnd(end.toString());
		
		AdventureDTO adv=this.adventureService.findById(dto.getAdventureId());
		adventureReservationDTO.setAdventure(adv);
		
		ClientProfileDTO client=this.clientService.findByIdDTO(dto.getClientId());
		adventureReservationDTO.setClient(client);
		
		adventureReservationDTO.setPrice(dto.getPrice());
		adventureReservationDTO.setNumberOfPersons(dto.getNumberOfPersons());
		adventureReservationDTO.setAdditionalItems(dto.getAdditionalItems());
		adventureReservationDTO.setSystemEarning(dto.getSystemEarning());
		
		return adventureReservationDTO;
	}
	
	public AdventureReservation deleteReservation(Long id) {
		Optional<AdventureReservation> opt =this.findById(id);
		if(!opt.isPresent()) {
			return null;
		}
		AdventureReservation found=opt.get();
		//pre nego sto se reservacija obrise treba proveriti da li je manje od 3 dana do pocetka avanture
		LocalDateTime lt= LocalDateTime.now();
		if (found.getReservationStart().getDayOfYear()>=lt.getDayOfYear()+3) {
			found.setDeleted(true);
			//treba obrisati zauzetosti za tu avanturu
			found.getAdventure().setUnavailability(null);
			found.setAdditionalItems(null);
			AdventureReservation saved=this.adventureReservationRepository.save(found);
			
			return saved;			
		}
		return null;
	}
}
