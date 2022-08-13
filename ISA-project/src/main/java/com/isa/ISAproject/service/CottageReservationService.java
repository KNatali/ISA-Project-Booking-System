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
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.CottageComplaintDTO;
import com.isa.ISAproject.dto.CottageReservationClientDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.dto.ReserveCottageFastReservation;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.CottageReservationMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.ComplaintType;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.CottageComplaint;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.model.SystemEarnings;
import com.isa.ISAproject.model.TimePeriod;
import com.isa.ISAproject.model.UnavailabilityType;
import com.isa.ISAproject.repository.ClientRepository;
import com.isa.ISAproject.repository.CottageComplaintRepository;
import com.isa.ISAproject.repository.CottageRepository;
import com.isa.ISAproject.repository.CottageReservationRepository;
import com.isa.ISAproject.repository.SystemEarningsRepository;

@Service
public class CottageReservationService {
	@Autowired
	private CottageReservationRepository cottageReservationRepository;
	@Autowired
	private CottageRepository cottageRepository;
	@Autowired
	private CottageComplaintRepository cottageComplaintRepository;
	@Autowired
	private TimePeriodService timePeriodService;
	@Autowired 
	private EmailService emailService;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private SystemEarningsRepository systemEarningsRepository;

	
	public List<CottageReservation> findAll() {
		return this.cottageReservationRepository.findAll();
	}
	public CottageReservation save(CottageReservation newRes) {
		return this.cottageReservationRepository.save(newRes);
	}
	public List<CottageReservation> sortByPrice(Long id) {
		List<CottageReservation> reservations=this.oldReservation(id);
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
		List<CottageReservation> reservations=this.oldReservation(id);
		List<CottageReservation> res=new ArrayList<>();
		List<CottageReservation> sorted=this.cottageReservationRepository.findByOrderByReservationStartDesc();
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
		List<CottageReservation> reservations=this.oldReservation(id);
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
			if(r.getReservationStart().isAfter(lt) && !r.isDeleted()) {
				res.add(r);
			}
		}
		return res;
	}
	public List<CottageReservation> oldReservation(Long id){
		List<CottageReservation> allRes=this.findAllResByIdClient(id);
		List<CottageReservation> res=new ArrayList<>();
		LocalDateTime lt= LocalDateTime.now();
		for (CottageReservation r : allRes) {
			if(r.getReservationStart().isBefore(lt) && !r.isDeleted()) {
				res.add(r);
			}
		}
		return res;
	}
	
	@Transactional(readOnly = false)
	public CottageReservationDTO addCottageReservation(CottageReservationDTO dto) throws PessimisticLockingFailureException, DateTimeException {
		Cottage cottage=cottageRepository.getById(dto.getCottage().getId());
		Client client=clientRepository.getById(dto.getClient().getId());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getReservationStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getReservationEnd(),formatter);
		
		
		TimePeriodDTO time=new TimePeriodDTO();
		time.setStart(dto.getReservationStart());
		time.setEnd(dto.getReservationEnd());
		time.setType(UnavailabilityType.Reservation);
		
		timePeriodService.setUnavailabilityCottageOwner(time, dto.getCottage().getId());
				
		
		
		long days = Duration.between(start, end).toDays();
		int price=(int) (cottage.getPrice()*days*dto.getMaxPersons());
		Set<AdditionalItem> items=new HashSet<>();
		for (AdditionalItemDTO adto : dto.getAdditionalItems()) {
			AdditionalItem a=AdditionalItemMapper.convertFromDTO(adto);
			items.add(a);
			price+=a.getPrice();
			
		}
		double earning=SystemEarnings.percentage*price/100;
		CottageReservation res=new CottageReservation(dto.getId(),start,end,cottage,dto.getMaxPersons(),price,items,client,null,earning);
		res.setDuration((int)days);
		res.setSystemEarning(earning);
		cottageReservationRepository.save(res);
		List<CottageReservation> list=client.getCottageReservations();
		list.add(res);
		clientRepository.save(client);
		
		String message="Cottage owner has been make reservation for you for cottage "+cottage.getName()+".Check this in your reservation list";
		
			try {
				this.emailService.sendMessage(client.getEmail(), message);
			} catch (MailException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		return CottageReservationMapper.convertToDTO(res);
	}
	public Optional<CottageReservation> findById(Long id) {
		return this.cottageReservationRepository.findById(id);
	}

	public CottageReservationDTO  addCottageReservationClient(CottageReservationClientDTO dto)
	{
		Optional<Client> clientOpt=this.clientRepository.findById(dto.getClientId());
		if(!clientOpt.isPresent()) {
			return null;
		}
		Client client=clientOpt.get();///////client
	
		Optional<Cottage> cottageOpt=this.cottageRepository.findById(dto.getCottageId());
		if(!cottageOpt.isPresent()) {
			return null;
		}
		Cottage cottage=cottageOpt.get();////boat
	
		CottageReservation cottageReservation=new CottageReservation();
	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getReservationStart(),formatter);
		LocalDateTime end = start.plusDays(dto.getNumberOfDays());
	
		cottageReservation.setReservationStart(start);
		cottageReservation.setReservationEnd(end);
		cottageReservation.setCottage(cottage);
		cottageReservation.setClient(client);
	
		Set<AdditionalItem> items=new HashSet<>();
		int price=(int) (cottage.getPrice()*dto.getNumberOfDays()*dto.getNumberOfPersons());
		for (AdditionalItemDTO adto : dto.getAdditionalItems()) {
			AdditionalItem a=AdditionalItemMapper.convertFromDTO(adto);
			items.add(a);
			price+=a.getPrice();		
		}
		cottageReservation.setAdditionalItems(items);
		cottageReservation.setSystemEarning(price);
		cottageReservation.setPrice(price);
		cottageReservation.setMaxPersons(dto.getNumberOfPersons());
	
		int day_start=start.getDayOfYear();
		int day_end=end.getDayOfYear();
	
		int duration=day_end-day_start;
		cottageReservation.setDuration(duration);
		
		TimePeriod period=new TimePeriod(null, start, end, UnavailabilityType.Reservation);
		cottage.getUnavailability().add(period);
		this.cottageRepository.save(cottage); 
		
		CottageReservation saved=this.cottageReservationRepository.save(cottageReservation);
	
		String message="Yoe successufuly made reservation for cottage "+cottage.getName()+".Check this in your reservation list";
	
		try {
			this.emailService.sendMessage(client.getEmail(), message);
		} catch (MailException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CottageReservationMapper.convertToDTO(saved);
	}
	public CottageReservationClientDTO convertReserveCottageFastReservation(ReserveCottageFastReservation dto) {
		CottageReservationClientDTO converted=new CottageReservationClientDTO();
		converted.setReservationStart(dto.getReservationStart());
		//
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getReservationStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getReservationEnd(),formatter);
		int startDay=start.getDayOfYear();
		int endDay=end.getDayOfYear();
		int duration=endDay-startDay;
		converted.setNumberOfDays(duration);
		converted.setNumberOfPersons(dto.getMaxPersons());
		converted.setAdditionalItems(dto.getAdditionalItems());
		converted.setClientId(dto.getClient().getId());
		converted.setCottageId(dto.getCottage().getId());
		return converted;
	}

	public CottageReservation deleteReservation(Long id) {
		Optional<CottageReservation> opt =this.findById(id);
		if(!opt.isPresent()) {
			return null;
		}
		CottageReservation found=opt.get();
		LocalDateTime lt= LocalDateTime.now();
		if(found.getReservationStart().getDayOfYear()>=lt.getDayOfYear()+3) {
			found.setDeleted(true);
			//treba obrisati zauzetosti za tu avanturu
			found.getCottage().setUnavailability(null);
			found.setAdditionalItems(null);
			CottageReservation saved=this.cottageReservationRepository.save(found);
			return saved;
		}
		return null;
	}
	
	public List<CottageComplaintDTO> getCottageComplaints(){
		List<CottageComplaint> complaints=cottageComplaintRepository.findAll();
		List<CottageComplaintDTO> res=new ArrayList<>();
		if(complaints!=null) {
			for (CottageComplaint c : complaints) {
				if(c.getType()==ComplaintType.Default) {
					ClientProfileDTO client=new ClientProfileDTO(c.getClient());
					CottageReservationDTO  boat=CottageReservationMapper.convertToDTO(c.getCottageReservation());
					CottageComplaintDTO cDTO=new CottageComplaintDTO(c.getId(),c.getDescription(),client,boat);
					res.add(cDTO);
				}
			}
		}
		
		return res;
	}
}
