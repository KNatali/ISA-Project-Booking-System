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
import com.isa.ISAproject.dto.AdventureFastReservationDTO;
import com.isa.ISAproject.dto.AdventureReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.dto.CottageFastReservationDTO;
import com.isa.ISAproject.dto.CottageOwnerProfileDTO;
import com.isa.ISAproject.dto.CottageOwnerReportDTO;
import com.isa.ISAproject.dto.CottageReservationDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.dto.PasswordChangeDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.AdventureFastReservationMapper;
import com.isa.ISAproject.mapper.AdventureReservationMapper;
import com.isa.ISAproject.mapper.CottageFastReservationMapper;
import com.isa.ISAproject.mapper.CottageMapper;
import com.isa.ISAproject.mapper.CottageReservationMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.AdventureFastReservation;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.CottageFastReservation;
import com.isa.ISAproject.model.CottageOwner;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.AddressRepository;
import com.isa.ISAproject.repository.ClientRepository;
import com.isa.ISAproject.repository.CottageFastReservationRepository;
import com.isa.ISAproject.repository.CottageOwnerRepository;
import com.isa.ISAproject.repository.CottageReservationRepository;

@Service
public class CottageOwnerService {
	@Autowired
	private CottageOwnerRepository cottageOwnerRepository;
	@Autowired
	private CottageReservationRepository cottageReservationRepository;
	@Autowired
	private CottageFastReservationRepository fastReservationRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<CottageOwner> findAll()
	{
		return this.cottageOwnerRepository.findAll();
	}
	public Page<CottageOwner> findAll(Pageable page)
	{
		return cottageOwnerRepository.findAll(page);
	}
	public Optional<CottageOwner> findById(Long id)
	{
		return this.cottageOwnerRepository.findById(id);
	}
	public CottageOwner save(CottageOwner newCottageOwner)
	{
		return this.cottageOwnerRepository.save(newCottageOwner);
	}
	public CottageOwner findByFirstNameAndLastName(String firstName, String lastName) 
	{
		return this.cottageOwnerRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	public List<CottageOwner> sortByFirstName(){
		return this.cottageOwnerRepository.findByOrderByFirstName();
	}
	public List<CottageOwner> sortByGrade(){
		return this.cottageOwnerRepository.findByOrderByGradeDesc();
	}
	/*public List<CottageReservationDTO> getReservations(Long id){
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
	
	/*public List<CottageFastReservationDTO> getFastReservations(Long id){
		List<CottageFastReservationDTO> res=new ArrayList<>();
		List<CottageFastReservation> temp=new ArrayList<>();
		List<CottageFastReservation> reservations=fastReservationRepository.findAll();
		
		for (CottageFastReservation c : reservations) {
			//res.add(CottageFastReservationMapper.convertToDTO(c));
			CottageDTO cottage=CottageMapper.convertToDTO(c.getCottage());
			//ClientProfileDTO client=new ClientProfileDTO(c.getClient());
			Set<AdditionalItemDTO> items=new HashSet<>();
			for (AdditionalItem i : c.getAdditionalItems()) {
				AdditionalItemDTO dto=AdditionalItemMapper.convertToDTO(i);
				items.add(dto);
			}
			CottageFastReservationDTO ctfdto = new CottageFastReservationDTO(c.getId(), c.getReservationStart(), c.getReservationEnd(), c.getDuration(), c.getMaxPersons(), c.getPrice(), c.getValidityStart(), c.getValidityEnd(), cottage, items);
			res.add(ctfdto);
		}
	// OVO JE ISPRAVLJENO I RADI
		
		
		/*for (CottageReservation c : reservations) {
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
		}*/
		//return res;
	//}
	
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
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

			CottageReservationDTO ctdto = new CottageReservationDTO(c.getId(), c.getReservationStart().format(formatter), c.getReservationEnd().format(formatter), cottage, c.getPrice(), c.getMaxPersons(), client, null, items);
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
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

			CottageReservationDTO ctdto = new CottageReservationDTO(c.getId(), c.getReservationStart().format(formatter), c.getReservationEnd().format(formatter), cottage, c.getPrice(), c.getMaxPersons(), client, null, items);
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
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

			CottageReservationDTO ctdto = new CottageReservationDTO(c.getId(), c.getReservationStart().format(formatter), c.getReservationEnd().format(formatter), cottage, c.getPrice(), c.getMaxPersons(), client, null, items);
			res.add(ctdto);
		}
		return res;
	}
	public CottageOwnerProfileDTO changePassword(Long id,PasswordChangeDTO dto) {
		CottageOwner cottageOwner=cottageOwnerRepository.getById(id);
		String newPasswordHash=passwordEncoder.encode(dto.getNewPassword());
		cottageOwner.setPassword(newPasswordHash);
		cottageOwnerRepository.save(cottageOwner);
		CottageOwnerProfileDTO cottageOwnerDTO=new CottageOwnerProfileDTO(cottageOwner);
		return cottageOwnerDTO;
	}
}
