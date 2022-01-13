package com.isa.ISAproject.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.BoatOwnerProfileDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.PasswordChangeDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.BoatMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.repository.BoatOwnerRepository;
import com.isa.ISAproject.repository.BoatReservationRepository;
import com.isa.ISAproject.repository.ClientRepository;

@Service
public class BoatOwnerService {
	@Autowired
	private BoatOwnerRepository boatOwnerRepository;
	@Autowired
	private BoatReservationRepository boatReservationRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ClientRepository clientRepository;
	
	public List<BoatOwner> findAll()
	{
		return this.boatOwnerRepository.findAll();
	}
	public Page<BoatOwner> findAll(Pageable page)
	{
		return boatOwnerRepository.findAll(page);
	}
	public Optional<BoatOwner> findById(Long id)
	{
		return this.boatOwnerRepository.findById(id);
	}
	public BoatOwner save(BoatOwner newBoatOwner)
	{
		return this.boatOwnerRepository.save(newBoatOwner);
	}
	public BoatOwner findByFirstNameAndLastName(String firstName, String lastName) 
	{
		return this.boatOwnerRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	public List<BoatOwner> sortByFirstName(){
		return this.boatOwnerRepository.findByOrderByFirstName();
	}
	public List<BoatOwner> sortByGrade(){
		return this.boatOwnerRepository.findByOrderByGradeDesc();
	}
	public BoatOwnerProfileDTO changePassword(Long id,PasswordChangeDTO dto) {
		BoatOwner boatOwner=boatOwnerRepository.getById(id);
		String newPasswordHash=passwordEncoder.encode(dto.getNewPassword());
		boatOwner.setPassword(newPasswordHash);
		boatOwnerRepository.save(boatOwner);
		BoatOwnerProfileDTO boatOwnerDTO=new BoatOwnerProfileDTO(boatOwner);
		return boatOwnerDTO;
	}
	public ClientProfileDTO getReservationClilent(Long id) {
		Optional<Client> item=this.clientRepository.findById(id);
		
		if(!item.isPresent()) {
			return null;
		}
		ClientProfileDTO itemDto=new ClientProfileDTO(item.get());
		return itemDto;
	}
	
	public List<BoatReservationDTO> getCompletedReservations(Long id){
		List<BoatReservationDTO> res=new ArrayList<>();
		List<BoatReservation> temp=new ArrayList<>();
		List<BoatReservation> reservations=boatReservationRepository.findAll();
		for (BoatReservation b : reservations) {
			if(b.getBoat().getOwner().getId()==id && b.getReservationEnd().isBefore(LocalDateTime.now()))
				temp.add(b);
		}
		for (BoatReservation b : temp) {
			//res.add(CottageReservationMapper.convertToDTO(c));
			BoatDTO boat=BoatMapper.convertToDTO(b.getBoat());
			//CottageOwnerReportDTO report=new CottageOwnerReportDTO(c.getReport().getId(),c.getOwnerReport().getContent(),c.getOwnerReport().isSanctioned(),c.getOwnerReport().isShowedUp());
			ClientProfileDTO client=new ClientProfileDTO(b.getClient());
			Set<AdditionalItemDTO> items=new HashSet<>();
			for (AdditionalItem i : b.getAdditionalItems()) {
				AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
				items.add(dto);
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

			BoatReservationDTO btdto = new BoatReservationDTO(b.getId(), b.getReservationStart().format(formatter), b.getReservationEnd().format(formatter), boat, b.getPrice(), b.getMaxPersons(), client, null, items);
			res.add(btdto);
		}
		return res;
	}
	public List<BoatReservationDTO> getActiveReservations(Long id){
		List<BoatReservationDTO> res=new ArrayList<>();
		List<BoatReservation> temp=new ArrayList<>();
		List<BoatReservation> reservations=boatReservationRepository.findAll();
		for (BoatReservation b : reservations) {
			if(b.getBoat().getOwner().getId()==id && b.getReservationEnd().isAfter(LocalDateTime.now()) && b.getReservationStart().isBefore(LocalDateTime.now()))
				temp.add(b);
		}
		for (BoatReservation b : temp) {
			//res.add(CottageReservationMapper.convertToDTO(c));
			BoatDTO boat=BoatMapper.convertToDTO(b.getBoat());
			//CottageOwnerReportDTO report=new CottageOwnerReportDTO(c.getReport().getId(),c.getOwnerReport().getContent(),c.getOwnerReport().isSanctioned(),c.getOwnerReport().isShowedUp());
			ClientProfileDTO client=new ClientProfileDTO(b.getClient());
			Set<AdditionalItemDTO> items=new HashSet<>();
			for (AdditionalItem i : b.getAdditionalItems()) {
				AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
				items.add(dto);
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

			BoatReservationDTO btdto = new BoatReservationDTO(b.getId(), b.getReservationStart().format(formatter), b.getReservationEnd().format(formatter), boat, b.getPrice(), b.getMaxPersons(), client, null, items);
			res.add(btdto);
		}
		return res;
		
	}
	public List<BoatReservationDTO> getUpcomingReservations(Long id){
		List<BoatReservationDTO> res=new ArrayList<>();
		List<BoatReservation> temp=new ArrayList<>();
		List<BoatReservation> reservations=boatReservationRepository.findAll();
		for (BoatReservation b : reservations) {
			if(b.getBoat().getOwner().getId()==id && b.getReservationStart().isAfter(LocalDateTime.now()))
				temp.add(b);
		}
		for (BoatReservation b : temp) {
			//res.add(CottageReservationMapper.convertToDTO(c));
			BoatDTO boat=BoatMapper.convertToDTO(b.getBoat());
			//CottageOwnerReportDTO report=new CottageOwnerReportDTO(c.getReport().getId(),c.getOwnerReport().getContent(),c.getOwnerReport().isSanctioned(),c.getOwnerReport().isShowedUp());
			ClientProfileDTO client=new ClientProfileDTO(b.getClient());
			Set<AdditionalItemDTO> items=new HashSet<>();
			for (AdditionalItem i : b.getAdditionalItems()) {
				AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
				items.add(dto);
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

			BoatReservationDTO btdto = new BoatReservationDTO(b.getId(), b.getReservationStart().format(formatter), b.getReservationEnd().format(formatter), boat, b.getPrice(), b.getMaxPersons(), client, null, items);
			res.add(btdto);
		}
		return res;
	}
}
