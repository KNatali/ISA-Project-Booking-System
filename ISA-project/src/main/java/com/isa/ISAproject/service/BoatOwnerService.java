package com.isa.ISAproject.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.mapper.BoatMapper;
import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.repository.BoatOwnerRepository;
import com.isa.ISAproject.repository.BoatReservationRepository;

@Service
public class BoatOwnerService {
	@Autowired
	private BoatOwnerRepository boatOwnerRepository;
	@Autowired
	private BoatReservationRepository boatReservationRepository;
	
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
	/*public List<BoatReservationDTO> getReservations(Long id){
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
			ClientProfileDTO client=new ClientProfileDTO(c.getClient());
			Set<AdditionalItemDTO> items=new HashSet<>();
			for (AdditionalItem i : c.getAdditionalItems()) {
				AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
				items.add(dto);
			}
			CottageReservationDTO ctdto = new CottageReservationDTO(c.getId(), c.getReservationStart(), c.getReservationEnd(), cottage, c.getPrice(), c.getMaxPersons(), client, null, items);
			res.add(ctdto);
		}
		return res;
	}
	
	public List<CottageFastReservationDTO> getFastReservations(Long id){
		List<CottageFastReservationDTO> res=new ArrayList<>();
		List<CottageFastReservation> temp=new ArrayList<>();
		List<CottageFastReservation> reservations=fastReservationRepository.findAll();
		
		for (CottageFastReservation c : reservations) {
			res.add(CottageFastReservationMapper.convertToDTO(c));
		}
		return res;
	}
	
	public ClientProfileDTO getReservationClilent(Long id) {
		Optional<Client> item=this.clientRepository.findById(id);
		
		if(!item.isPresent()) {
			return null;
		}
		ClientProfileDTO itemDto=new ClientProfileDTO(item.get());
		return itemDto;
	}
	
	public List<CottageReservationDTO> getCompletedReservations(Long id){
		List<CottageReservationDTO> res=new ArrayList<>();
		List<CottageReservation> temp=new ArrayList<>();
		List<CottageReservation> reservations=cottageReservationRepository.findAll();
		for (CottageReservation c : reservations) {
			if(c.getCottage().getCottageOwner().getId()==id && c.getReservationEnd().isBefore(LocalDateTime.now()))
				temp.add(c);
		}
		for (CottageReservation c : temp) {
			//res.add(CottageReservationMapper.convertToDTO(c));
			CottageDTO cottage=CottageMapper.convertToDTO(c.getCottage());
			//CottageOwnerReportDTO report=new CottageOwnerReportDTO(c.getReport().getId(),c.getOwnerReport().getContent(),c.getOwnerReport().isSanctioned(),c.getOwnerReport().isShowedUp());
			ClientProfileDTO client=new ClientProfileDTO(c.getClient());
			Set<AdditionalItemDTO> items=new HashSet<>();
			for (AdditionalItem i : c.getAdditionalItems()) {
				AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
				items.add(dto);
			}
			CottageReservationDTO ctdto = new CottageReservationDTO(c.getId(), c.getReservationStart(), c.getReservationEnd(), cottage, c.getPrice(), c.getMaxPersons(), client, null, items);
			res.add(ctdto);
		}
		return res;
	}
	
	public List<CottageOwner> sortByCity(){
		List<CottageOwner> allOwners=this.cottageOwnerRepository.findAll();
		List<Address> allAddressesSortByCities=this.addressRepository.findByOrderByCity();
		List<CottageOwner> res=new ArrayList<>();
		for (Address address : allAddressesSortByCities) {
			for (CottageOwner cottageOwners : allOwners) {
				if(cottageOwners.getAddress().getId().equals(address.getId())  ) {
					res.add(cottageOwners);
				}
			}
		}
		return res;
	}
	
	public List<CottageReservationDTO> getActiveReservations(Long id){
		List<CottageReservationDTO> res=new ArrayList<>();
		List<CottageReservation> temp=new ArrayList<>();
		List<CottageReservation> reservations=cottageReservationRepository.findAll();
		for (CottageReservation c : reservations) {
			if(c.getCottage().getCottageOwner().getId()==id && c.getReservationEnd().isAfter(LocalDateTime.now()) && c.getReservationStart().isBefore(LocalDateTime.now()))
				temp.add(c);
		}
		for (CottageReservation c : temp) {
			//res.add(CottageReservationMapper.convertToDTO(c));
			CottageDTO cottage=CottageMapper.convertToDTO(c.getCottage());
			//CottageOwnerReportDTO report=new CottageOwnerReportDTO(c.getReport().getId(),c.getOwnerReport().getContent(),c.getOwnerReport().isSanctioned(),c.getOwnerReport().isShowedUp());
			ClientProfileDTO client=new ClientProfileDTO(c.getClient());
			Set<AdditionalItemDTO> items=new HashSet<>();
			for (AdditionalItem i : c.getAdditionalItems()) {
				AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
				items.add(dto);
			}
			CottageReservationDTO ctdto = new CottageReservationDTO(c.getId(), c.getReservationStart(), c.getReservationEnd(), cottage, c.getPrice(), c.getMaxPersons(), client, null, items);
			res.add(ctdto);
		}
		return res;
		
	}
	public List<CottageReservationDTO> getUpcomingReservations(Long id){
		List<CottageReservationDTO> res=new ArrayList<>();
		List<CottageReservation> temp=new ArrayList<>();
		List<CottageReservation> reservations=cottageReservationRepository.findAll();
		for (CottageReservation c : reservations) {
			if(c.getCottage().getCottageOwner().getId()==id && c.getReservationStart().isAfter(LocalDateTime.now()))
				temp.add(c);
		}
		for (CottageReservation c : temp) {
			//res.add(CottageReservationMapper.convertToDTO(c));
			CottageDTO cottage=CottageMapper.convertToDTO(c.getCottage());
			//CottageOwnerReportDTO report=new CottageOwnerReportDTO(c.getReport().getId(),c.getOwnerReport().getContent(),c.getOwnerReport().isSanctioned(),c.getOwnerReport().isShowedUp());
			ClientProfileDTO client=new ClientProfileDTO(c.getClient());
			Set<AdditionalItemDTO> items=new HashSet<>();
			for (AdditionalItem i : c.getAdditionalItems()) {
				AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
				items.add(dto);
			}
			CottageReservationDTO ctdto = new CottageReservationDTO(c.getId(), c.getReservationStart(), c.getReservationEnd(), cottage, c.getPrice(), c.getMaxPersons(), client, null, items);
			res.add(ctdto);
		}
		return res;
		
	}*/
}
