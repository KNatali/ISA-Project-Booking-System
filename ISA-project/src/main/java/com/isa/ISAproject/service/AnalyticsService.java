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
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.dto.TimePeriodDTO;
import com.isa.ISAproject.mapper.AdventureReservationMapper;
import com.isa.ISAproject.mapper.BoatReservationMapper;
import com.isa.ISAproject.mapper.CottageReservationMapper;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.CottageOwner;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.AdventureReservationRepository;
import com.isa.ISAproject.repository.BoatReservationRepository;
import com.isa.ISAproject.repository.CottageReservationRepository;

@Service
public class AnalyticsService {
	

	@Autowired
	private AdventureReservationService adventureReservationService;
	@Autowired
	private InstructorService instructorService;
	@Autowired
	private AdventureReservationRepository adventureReservationRepository;

	@Autowired
	private CottageReservationService cottageReservationService;
	@Autowired
	private CottageOwnerService cottageOwnerService;
	@Autowired
	private CottageReservationRepository cottageReservationRepository;
	
	@Autowired
	private BoatReservationService boatReservationService;
	@Autowired
	private BoatOwnerService boatOwnerService;
	@Autowired
	private BoatReservationRepository boatReservationRepository;
	
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
	
	/**/
	
	public Double getCottageEarnings(TimePeriodDTO dto){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		List<CottageReservation> list=this.cottageReservationService.findAll();
		
		double earnings=0;
		for (CottageReservation c : list) {
			if(c.getReservationEnd().isAfter(start) && c.getReservationEnd().isBefore(end) )
				earnings+=c.getSystemEarning();
		}
		return earnings;
	}
	public Double getCottageOwnerEarnings(TimePeriodDTO dto,Long id){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		
		List<CottageReservation> temp=new ArrayList<>();
		List<CottageReservation> reservations=cottageReservationRepository.findAll();
		for (CottageReservation c : reservations) {
			if(c.getCottage().getCottageOwner().getId()==id)
				temp.add(c);
		}
		double earnings=0;
		for (CottageReservation c : temp) {
			if(c.getReservationEnd().isAfter(start) && c.getReservationEnd().isBefore(end))
				earnings+=(c.getPrice()-c.getSystemEarning());
		}
		return earnings;
	}
	
	public List<CottageReservationDTO> getCottageOwnerReservations(Long id){
		List<CottageReservationDTO> res=new ArrayList<>();
		List<CottageReservation> temp=new ArrayList<>();
		List<CottageReservation> reservations=cottageReservationRepository.findAll();
		for (CottageReservation c : reservations) {
			if(c.getCottage().getCottageOwner().getId()==id)
				temp.add(c);
		}
		for (CottageReservation c : temp) {
			res.add(CottageReservationMapper.convertToDTO(c));
		}
		return res;	
	}
	
	public Double cottageOwnerAverageGrade(Long id) {
		Optional<CottageOwner> itemOptionals=this.cottageOwnerService.findById(id);
		CottageOwner cottageOwner=itemOptionals.get();
		Set<Cottage> cottages=cottageOwner.getCottages();
		double grade=0;
		int count=0;
		double averageGrade=0;
		for(Cottage c:cottages) {
			if(c.getGrade()!=0) {
				grade+=c.getGrade();
				count++;
			}
		}
		averageGrade=grade/count;
		return averageGrade;
	}
	
	/**/
	
	public Double getBoatEarnings(TimePeriodDTO dto){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		List<BoatReservation> list=this.boatReservationService.findAll();
		
		double earnings=0;
		for (BoatReservation b : list) {
			if(b.getReservationEnd().isAfter(start) && b.getReservationEnd().isBefore(end) )
				earnings+=b.getSystemEarning();
		}
		return earnings;
	}
	public Double getBoatOwnerEarnings(TimePeriodDTO dto,Long id){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		
		List<BoatReservation> temp=new ArrayList<>();
		List<BoatReservation> reservations=boatReservationRepository.findAll();
		for (BoatReservation b : reservations) {
			if(b.getBoat().getOwner().getId()==id)
				temp.add(b);
		}
		double earnings=0;
		for (BoatReservation b : temp) {
			if(b.getReservationEnd().isAfter(start) && b.getReservationEnd().isBefore(end))
				earnings+=(b.getPrice()-b.getSystemEarning());
		}
		return earnings;
	}
	
	public List<BoatReservationDTO> getBoatOwnerReservations(Long id){
		List<BoatReservationDTO> res=new ArrayList<>();
		List<BoatReservation> temp=new ArrayList<>();
		List<BoatReservation> reservations=boatReservationRepository.findAll();
		for (BoatReservation b : reservations) {
			if(b.getBoat().getOwner().getId()==id)
				temp.add(b);
		}
		for (BoatReservation b : temp) {
			res.add(BoatReservationMapper.convertToDTO(b));
		}
		return res;	
	}
	
	public Double boatOwnerAverageGrade(Long id) {
		Optional<BoatOwner> itemOptionals=this.boatOwnerService.findById(id);
		BoatOwner boatOwner=itemOptionals.get();
		Set<Boat> boats=boatOwner.getBoats();
		double grade=0;
		int count=0;
		double averageGrade=0;
		for(Boat b:boats) {
			if(b.getGrade()!=0) {
				grade+=b.getGrade();
				count++;
			}
		}
		averageGrade=grade/count;
		return averageGrade;
	}
}