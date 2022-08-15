package com.isa.ISAproject.service;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.PessimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.ISAproject.dto.TimePeriodDTO;

import com.isa.ISAproject.exception.ResourceConflictException;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.CottageOwner;

import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.model.TimePeriod;
import com.isa.ISAproject.repository.BoatOwnerRepository;
import com.isa.ISAproject.repository.BoatRepository;
import com.isa.ISAproject.repository.CottageOwnerRepository;
import com.isa.ISAproject.repository.CottageRepository;
import com.isa.ISAproject.repository.InstructorRepository;
import com.isa.ISAproject.repository.TimePeriodRepository;

import javassist.NotFoundException;

@Service
public class TimePeriodService {
	
	@Autowired
	private TimePeriodRepository timePeriodRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private BoatRepository boatRepository;
	@Autowired
	private CottageRepository cottageRepository;
	@Autowired
	private CottageOwnerRepository cottageOwnerRepository;
	@Autowired
	private BoatOwnerRepository boatOwnerRepository;
	
	@Transactional(readOnly = false)
	public boolean setUnavailabilityInstructor(TimePeriodDTO dto,Long id)throws PessimisticLockException, DateTimeException, InterruptedException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		TimePeriod period=new TimePeriod(dto.getId(),start,end,dto.getType());
		Instructor instructor=new Instructor();
		
		instructor=instructorRepository.findOneById(id);
		
		Set<TimePeriod> periods=new HashSet<>();
			if(instructor.getUnavailability()!=null) {
				periods=instructor.getUnavailability();
				for (TimePeriod t : periods) {
					if(t.getStartTime().isBefore(end) &&  start.isBefore(t.getEndTime())) {
						throw new DateTimeException("Overlapping");
					}
				}
			}
			//this.timePeriodRepository.save(period);
			periods.add(period);
			this.instructorRepository.save(instructor);
			Thread.sleep(500);
			
		
		return true;
	
	}
	
	public boolean removeUnavailabilityInstructor(TimePeriodDTO dto,Long id) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		TimePeriod period=new TimePeriod(dto.getId(),start,end,dto.getType());
		Instructor instructor=instructorRepository.getById(id);
		Set<TimePeriod> periods=new HashSet<>();
		if(instructor.getUnavailability()!=null) {
			periods=instructor.getUnavailability();
			for (TimePeriod t : periods) {
				if(t.getStartTime().toLocalDate().isEqual(start.toLocalDate()) &&  end.toLocalDate().isEqual(t.getEndTime().toLocalDate())) {
					//instructor.getUnavailability().remove(period);
					periods.remove(t);
					this.instructorRepository.save(instructor);
					this.timePeriodRepository.delete(period);
					return true;
				}
			}
		}
	
		return false;
	}
	
	
	
	public List<TimePeriodDTO> findUnavailabilityByInstructor(Long id){
		Instructor instructor=instructorRepository.getById(id);
		Set<TimePeriod> times=instructor.getUnavailability();
		List<TimePeriodDTO> timesDTO=new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		
		for (TimePeriod t : times) {
			
			TimePeriodDTO dto=new TimePeriodDTO(t.getId(),t.getStartTime().format(formatter),t.getEndTime().format(formatter),t.getTimeType());
			timesDTO.add(dto);
			
		}
		return timesDTO;
		
	}
	
/**/
	@Transactional(readOnly = false)
	public boolean setUnavailabilityCottageOwner(TimePeriodDTO dto,Long id)throws PessimisticLockException, DateTimeException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		TimePeriod period=new TimePeriod(dto.getId(),start,end,dto.getType());
		CottageOwner cottageOwner=new CottageOwner();
		
		cottageOwner=cottageOwnerRepository.findOneById(id);
		
		Set<TimePeriod> periods=new HashSet<>();
			if(cottageOwner.getUnavailability()!=null) {
				periods=cottageOwner.getUnavailability();
				for (TimePeriod t : periods) {
					if(t.getStartTime().isBefore(end) &&  start.isBefore(t.getEndTime())) {
						throw new DateTimeException("Overlapping");
					}
				}
			}
			//this.timePeriodRepository.save(period);
			periods.add(period);
			this.cottageOwnerRepository.save(cottageOwner);
		return true;
	}
	
	public boolean removeUnavailabilityCottageOwner(TimePeriodDTO dto,Long id) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		TimePeriod period=new TimePeriod(dto.getId(),start,end,dto.getType());
		CottageOwner cottageOwner=cottageOwnerRepository.getById(id);
		Set<TimePeriod> periods=new HashSet<>();
		if(cottageOwner.getUnavailability()!=null) {
			periods=cottageOwner.getUnavailability();
			for (TimePeriod t : periods) {
				if(t.getStartTime().toLocalDate().isEqual(start.toLocalDate()) &&  end.toLocalDate().isEqual(t.getEndTime().toLocalDate())) {
					periods.remove(t);
					this.cottageOwnerRepository.save(cottageOwner);
					this.timePeriodRepository.delete(period);
					return true;
				}
			}
		}
	
		return false;
	}
	
	
	
	public List<TimePeriodDTO> findUnavailabilityByCottageOwner(Long id){
		CottageOwner cottageOwner=cottageOwnerRepository.getById(id);
		Set<TimePeriod> times=cottageOwner.getUnavailability();
		List<TimePeriodDTO> timesDTO=new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		for (TimePeriod t : times) {
			TimePeriodDTO dto=new TimePeriodDTO(t.getId(),t.getStartTime().format(formatter),t.getEndTime().format(formatter),t.getTimeType());
			timesDTO.add(dto);
			
		}
		return timesDTO;		
	}
	public List<TimePeriodDTO> findUnavailabilityByCottage(Long id){
		Cottage cottage=cottageRepository.getById(id);
		Set<TimePeriod> times=cottage.getUnavailability();
		List<TimePeriodDTO> timesDTO=new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		for (TimePeriod t : times) {
			TimePeriodDTO dto=new TimePeriodDTO(t.getId(),t.getStartTime().format(formatter),t.getEndTime().format(formatter),t.getTimeType());
			timesDTO.add(dto);
			
		}
		return timesDTO;		
	}
	
/**/
	@Transactional(readOnly = false)
	public boolean setUnavailabilityBoatOwner(TimePeriodDTO dto,Long id)throws PessimisticLockException, DateTimeException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		TimePeriod period=new TimePeriod(dto.getId(),start,end,dto.getType());
		BoatOwner boatOwner=new BoatOwner();
		
		boatOwner=boatOwnerRepository.findOneById(id);
		
		Set<TimePeriod> periods=new HashSet<>();
			if(boatOwner.getUnavailability()!=null) {
				periods=boatOwner.getUnavailability();
				for (TimePeriod t : periods) {
					if(t.getStartTime().isBefore(end) &&  start.isBefore(t.getEndTime())) {
						throw new DateTimeException("Overlapping");
					}
				}
			}
			//this.timePeriodRepository.save(period);
			periods.add(period);
			this.boatOwnerRepository.save(boatOwner);
		return true;
	}
	
	public boolean removeUnavailabilityBoatOwner(TimePeriodDTO dto,Long id) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		TimePeriod period=new TimePeriod(dto.getId(),start,end,dto.getType());
		BoatOwner boatOwner=boatOwnerRepository.getById(id);
		Set<TimePeriod> periods=new HashSet<>();
		if(boatOwner.getUnavailability()!=null) {
			periods=boatOwner.getUnavailability();
			for (TimePeriod t : periods) {
				if(t.getStartTime().toLocalDate().isEqual(start.toLocalDate()) &&  end.toLocalDate().isEqual(t.getEndTime().toLocalDate())) {
					periods.remove(t);
					this.boatOwnerRepository.save(boatOwner);
					this.timePeriodRepository.delete(period);
					return true;
				}
			}
		}
	
		return false;
	}
	
	public List<TimePeriodDTO> findUnavailabilityByBoatOwner(Long id){
		BoatOwner boatOwner=boatOwnerRepository.getById(id);
		Set<TimePeriod> times=boatOwner.getUnavailability();
		List<TimePeriodDTO> timesDTO=new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		for (TimePeriod t : times) {
			TimePeriodDTO dto=new TimePeriodDTO(t.getId(),t.getStartTime().format(formatter),t.getEndTime().format(formatter),t.getTimeType());
			timesDTO.add(dto);
			
		}
		return timesDTO;		
	}
	public List<TimePeriodDTO> findUnavailabilityByBoat(Long id){
		Boat boat=boatRepository.getById(id);
		Set<TimePeriod> times=boat.getUnavailability();
		List<TimePeriodDTO> timesDTO=new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		for (TimePeriod t : times) {
			TimePeriodDTO dto=new TimePeriodDTO(t.getId(),t.getStartTime().format(formatter),t.getEndTime().format(formatter),t.getTimeType());
			timesDTO.add(dto);
			
		}
		return timesDTO;		
	}
	@Transactional(readOnly = false)
	public boolean setUnavailabilityBoat(TimePeriodDTO dto,Long id)throws PessimisticLockException, DateTimeException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		TimePeriod period=new TimePeriod(dto.getId(),start,end,dto.getType());
		Boat boat=new Boat();
		boat=boatRepository.findOneById(id);
		
		Set<TimePeriod> periods=new HashSet<>();
			if(boat.getUnavailability()!=null) {
				periods=boat.getUnavailability();
				for (TimePeriod t : periods) {
					if(t.getStartTime().isBefore(end) &&  start.isBefore(t.getEndTime())) {
						throw new DateTimeException("Overlapping");
					}
				}
			}
			//this.timePeriodRepository.save(period);
			periods.add(period);
			this.boatRepository.save(boat);
		
		return true;
		
		
	}
	
	@Transactional(readOnly = false)
	public boolean setUnavailabilityCottage(TimePeriodDTO dto,Long id)throws PessimisticLockException, DateTimeException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getStart(),formatter);
		LocalDateTime end = LocalDateTime.parse(dto.getEnd(),formatter);
		TimePeriod period=new TimePeriod(dto.getId(),start,end,dto.getType());
		Cottage cottage=new Cottage();
		cottage=cottageRepository.findOneById(id);
		
		Set<TimePeriod> periods=new HashSet<>();
			if(cottage.getUnavailability()!=null) {
				periods=cottage.getUnavailability();
				for (TimePeriod t : periods) {
					if(t.getStartTime().isBefore(end) &&  start.isBefore(t.getEndTime())) {
						throw new DateTimeException("Overlapping");
					}
				}
			}
			//this.timePeriodRepository.save(period);
			periods.add(period);
			this.cottageRepository.save(cottage);
		
		return true;
		
		
	}

}
