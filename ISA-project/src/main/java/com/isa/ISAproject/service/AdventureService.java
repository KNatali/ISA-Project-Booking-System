package com.isa.ISAproject.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AddressDTO;
import com.isa.ISAproject.dto.AdventureBehavioralRuleDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureAddDTO;
import com.isa.ISAproject.dto.AdventureFishingEquipmentDTO;
import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.dto.SearchAvailableAdventureByGradeDTO;
import com.isa.ISAproject.dto.SearchAvailableAdventureByPriceDTO;
import com.isa.ISAproject.dto.SearchForReservationDTO;
import com.isa.ISAproject.dto.UnsubscribedItemDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.AddressMapper;
import com.isa.ISAproject.mapper.AdventureBehavioralRuleMapper;
import com.isa.ISAproject.mapper.AdventureFishingEquipmentMapper;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.mapper.BoatMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureBehavioralRule;
import com.isa.ISAproject.model.AdventureFishingEquipment;

import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Client;

import com.isa.ISAproject.model.Cottage;

import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.model.TimePeriod;
import com.isa.ISAproject.repository.AdditionalItemRepository;
import com.isa.ISAproject.repository.AddressRepository;
import com.isa.ISAproject.repository.AdventureFishingEquipmentRepository;
import com.isa.ISAproject.repository.AdventureRepository;
import com.isa.ISAproject.repository.AdventureReservationRepository;
import com.isa.ISAproject.repository.InstructorRepository;
import com.isa.ISAproject.repository.BehavioralRuleRepository;
import com.isa.ISAproject.repository.ClientRepository;
@Service
public class AdventureService {
	@Autowired
	private AdventureRepository adventureRepository;
	@Autowired
	private AdventureReservationRepository adventureReservationRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AdventureFishingEquipmentRepository equipmentRepository;
	@Autowired
	private AdditionalItemRepository addtitionalItemRepository;
	@Autowired
	private BehavioralRuleRepository ruleRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private ClientService clientService;
	
	public List<AdventureDTO> findAll(){
		List<Adventure> allAdventures= this.adventureRepository.findAll();
		List<Adventure> nonDeletedAdventures=new ArrayList<Adventure>();
		for (Adventure adventure : allAdventures) {
			if(!adventure.isDeleted())
				nonDeletedAdventures.add(adventure);
		}
		return AdventureMapper.convertoToDTOs(nonDeletedAdventures);
		
	}
	
	  @Cacheable( value = "adventure" )
	public AdventureDTO findById(Long id) {
		Optional<Adventure> adventure=this.adventureRepository.findById(id);
		return AdventureMapper.convertToDTO(adventure.get());
	}

	
	public void delete(Long id) {
		Adventure a=adventureRepository.getById(id);
		a.setDeleted(true);
		this.adventureRepository.save(a);
	}
	public void addAdventure(Long instructorId, AdventureAddDTO dto) {
		Instructor instructor=instructorRepository.getById(instructorId);
		Address address=new Address();
		address.setStreet(dto.getAddress().getStreet());
		address.setCity(dto.getAddress().getCity());
		address.setState(dto.getAddress().getState());
			address.setLatitude(dto.getAddress().getLatitude());
			address.setLongitude(dto.getAddress().getLongitude());
		this.addressRepository.save(address);
		Set<Adventure> adventures=instructor.getAdventures();
		Set<AdventureFishingEquipment> equipment=AdventureFishingEquipmentMapper.converFromDTOs(dto.getEquipment());
		this.equipmentRepository.saveAll(equipment);
		
		Set<AdditionalItem> items=new HashSet<>();
		for (AdditionalItemDTO adto : dto.getAdditionalItems()) {
			AdditionalItem a=AdditionalItemMapper.convertFromDTO(adto);
			items.add(a);
			
		}
		this.addtitionalItemRepository.saveAll(items);
		Set<AdventureBehavioralRule> rules=new HashSet<>();
		for (AdventureBehavioralRuleDTO rdto : dto.getRules()) {
			AdventureBehavioralRule a=AdventureBehavioralRuleMapper.convertFromDTO(rdto);
			rules.add(a);
			
		}
		this.ruleRepository.saveAll(rules);
		Adventure a=new Adventure(dto.getId(),dto.getName(),address,dto.getDescription(),0,dto.getPrice(),instructor,dto.getMainPicture(),null,dto.getMaxPersons(),equipment,rules,dto.getCancellationPercentage(),null,items,null);
		this.adventureRepository.save(a);
	}
	
	

	public List<Adventure> findByInstructor(Instructor instructor){
		return this.adventureRepository.findByInstructor(instructor);
	}
	public boolean editAdventure(Long id,AdventureDTO dto) {
		Adventure a=adventureRepository.getById(id);
		a.setName(dto.getName());
		a.getAddress().setStreet(dto.getAddress().getStreet());
		a.getAddress().setCity(dto.getAddress().getCity());
		a.getAddress().setState(dto.getAddress().getState());
		a.setMaxPersons(dto.getMaxPersons());
		a.setMainPicture(dto.getMainPicture());
		a.setCancellationPercentage(dto.getCancellationPercentage());
		a.setPrice(dto.getPrice());
		a.setDescription(dto.getDescription());
		a.getInstructor().setBiography(dto.getInstructor().getBiography());
		
		this.adventureRepository.save(a);
		
	
		return true;
	}
	
	public List<AdventureFishingEquipmentDTO> getAdventureEquipment(Long id){
		Optional<Adventure> adventure=this.adventureRepository.findById(id);
		Set<AdventureFishingEquipment> list=adventure.get().getEquipment();
		List<AdventureFishingEquipmentDTO> listDTO=new ArrayList<>();
		for(AdventureFishingEquipment a:list) { 
			AdventureFishingEquipmentDTO aDTO=AdventureFishingEquipmentMapper.convertToDTO(a);
			listDTO.add(aDTO);
		}
		return listDTO;
	}
	
	public void saveNewEquipment(Long id,AdventureFishingEquipmentDTO eDTO) {
		AdventureFishingEquipment e=AdventureFishingEquipmentMapper.convertFromDTO(eDTO);
		
		Adventure a=adventureRepository.getById(id);
		this.equipmentRepository.save(e);
		Set<AdventureFishingEquipment> list=a.getEquipment();
		list.add(e);
		//a.setEquipment(list);
		
		this.adventureRepository.save(a);
		
		
	}
	
	public boolean editEquipment(Long id,AdventureFishingEquipmentDTO eDTO) {
		AdventureFishingEquipment e=equipmentRepository.getById(eDTO.getId());
		AdventureFishingEquipment edited=new AdventureFishingEquipment();
		edited.setId(e.getId());
		edited.setName(eDTO.getName());
		this.equipmentRepository.save(edited);
		Adventure a=adventureRepository.getById(id);
		
		Set<AdventureFishingEquipment> list=a.getEquipment();
	list.remove(e);
	list.add(edited);
			
		
		
		return true;
	}
	
	public boolean deleteEquipment (Long adventureId,Long equipmentId) {
		AdventureFishingEquipment e=this.equipmentRepository.getById(equipmentId);
		Adventure a=this.adventureRepository.getById(adventureId);
		if(e==null || a==null) {
			return false;
		}
		Set<AdventureFishingEquipment> list=a.getEquipment();
		list.remove(e);
		
		this.equipmentRepository.delete(e);
		this.adventureRepository.save(a);
		return true;
		
	}
	
	public List<AdventureBehavioralRuleDTO> getAdventureRules(Long id){
		Optional<Adventure> adventure=this.adventureRepository.findById(id);
		Set<AdventureBehavioralRule> list=adventure.get().getRules();
		List<AdventureBehavioralRuleDTO> listDTO=new ArrayList<>();
		for(AdventureBehavioralRule a:list) { 
			AdventureBehavioralRuleDTO aDTO=AdventureBehavioralRuleMapper.convertToDTO(a);
			listDTO.add(aDTO);
		}
		return listDTO;
	}
	
	public List<AdditionalItemDTO> getAdventureAdditionalItems(Long id){
		Optional<Adventure> adventure=this.adventureRepository.findById(id);
		Set<AdditionalItem> list=adventure.get().getAdditionalItems();
		List<AdditionalItemDTO> listDTO=new ArrayList<>();
		for(AdditionalItem a:list) { 
			AdditionalItemDTO aDTO=AdditionalItemMapper.convertToDTO(a);
			listDTO.add(aDTO);
		}
		return listDTO;
	}
	public List<Adventure> findByName(String name){
		return this.adventureRepository.findByName(name);
	}
	public List<Adventure> findByCity(String city){
		List<Adventure> all=this.adventureRepository.findAll();
		List<Adventure> res=new ArrayList<>();
		for (Adventure adv : all) {
			if(adv.getAddress().getCity().equals(city)) {
				res.add(adv);
			}
		}
		return res;
	}
	public List<AdventureDTO> findAvailableByGrade(SearchAvailableAdventureByGradeDTO dto){
		List<Adventure> all_adventures=this.adventureRepository.findByAverageGrade(dto.getGrade());
		List<AdventureDTO> available_adventuredtos=dto.getAdventures();
		List<AdventureDTO> all_adventuresdtos=AdventureMapper.convertoToDTOs(all_adventures);
		List<AdventureDTO> res=new ArrayList<AdventureDTO>();
		
		for (AdventureDTO adventure : available_adventuredtos) {
			for (AdventureDTO adventure2 : all_adventuresdtos) {
				if (adventure.getId()==adventure2.getId()) {
					res.add(adventure);
				}
			}
		}
		return res;
	}
	public List<AdventureDTO> findAvailableByPrice(SearchAvailableAdventureByPriceDTO dto){
		List<Adventure> all_adventures=this.adventureRepository.findByPrice(dto.getPrice());
		List<AdventureDTO> available_adventuredtos=dto.getAdventures();
		List<AdventureDTO> all_adventuresdtos=AdventureMapper.convertoToDTOs(all_adventures);
		List<AdventureDTO> res=new ArrayList<AdventureDTO>();
		
		for (AdventureDTO adventure : available_adventuredtos) {
			for (AdventureDTO adventure2 : all_adventuresdtos) {
				if (adventure.getId()==adventure2.getId()) {
					res.add(adventure);
				}
			}
		}
		return res;
	}
	public List<Adventure> findAllAvailableAdventure(SearchForReservationDTO dto){
		//treba dobaviti sve brodove
		List<Adventure> adventures=this.adventureRepository.findAll();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getDateAndTime(),formatter);
		LocalDateTime end = start.plusHours(dto.getNumOfDay());

		List<Adventure> availableAdventures=new ArrayList<>();
		for (Adventure adventure : adventures) {
			Set<TimePeriod> unavailability=adventure.getUnavailability();//sve zautestosti jednog broda
			int broj_zauzetosti=unavailability.size();
			int brojac=0;//brokjim koliko yautesto se  preklapa sa zeljenim datumom
			for (TimePeriod timePeriod : unavailability) {
				if ((end.isAfter(timePeriod.getStartTime()) && end.isBefore(timePeriod.getEndTime()))||(start.isAfter(timePeriod.getStartTime()) && start.isBefore(timePeriod.getEndTime()))) {
					brojac++;
				}
			}
			if (broj_zauzetosti!=brojac || broj_zauzetosti==0) {
				availableAdventures.add(adventure);
			}
		}
		return availableAdventures;
	}

	public List<Adventure> sortByGradeAvailableAdventure(List<AdventureDTO> adventures) {
		List<Adventure> all_sorted_adventures = this.adventureRepository.findByOrderByAverageGradeDesc();
		List<Adventure> sorted_adventures =new ArrayList<>();
		for (Adventure adventure : all_sorted_adventures) {
			for (AdventureDTO adventure2 : adventures) {
				if(adventure.getId()==adventure2.getId()) {
					sorted_adventures.add(adventure);
				}
			}
		}
		return sorted_adventures;
	}
	
	public List<Adventure> sortByPriceAvailableAdventure(List<AdventureDTO> adventures) {
		List<Adventure> all_sorted_adventures = this.adventureRepository.findByOrderByPriceDesc();
		List<Adventure> sorted_adventures =new ArrayList<>();
		for (Adventure adventure : all_sorted_adventures) {
			for (AdventureDTO adventure2 : adventures) {
				if(adventure.getId()==adventure2.getId()) {
					sorted_adventures.add(adventure);
				}
			}
		}
		return sorted_adventures;
	}
	public List<AdventureDTO> getAllSubscribedAdventures(Long clientId){
		Optional<Client> opt=this.clientService.findById(clientId);
		if(!opt.isPresent()) {
			return null;
		}
		Client client=opt.get();
		Set<Adventure> subscribed=client.getSubscribedAdventures();
		List<Adventure> list_subscribed=new ArrayList<Adventure>();
		for (Adventure adv : subscribed) {
			list_subscribed.add(adv);
		}
		return AdventureMapper.convertoToDTOs(list_subscribed);
	}

	public boolean unsubscribedAdventure(UnsubscribedItemDTO dto){
		Optional<Client> opt=this.clientService.findById(dto.getClientId());
		if(!opt.isPresent()) {
			return false;
		}
		Client client=opt.get();

		Optional<Adventure> adventureOpt=this.adventureRepository.findById(dto.getEntityId());
		if(!adventureOpt.isPresent()) {
			return false;
		}
		Adventure adventure=adventureOpt.get();
		boolean deleted;
		client.getSubscribedAdventures().remove(adventure);
		deleted=adventure.getSubscribers().remove(client);
		this.adventureRepository.save(adventure);
		this.clientService.save(client);
		return deleted;
	}
	public boolean subscribe(UnsubscribedItemDTO dto){
		Optional<Client> opt=this.clientService.findById(dto.getClientId());
		if(!opt.isPresent()) {
			return false;
		}
		Client client=opt.get();

		Optional<Adventure> adventureOpt=this.adventureRepository.findById(dto.getEntityId());
		if(!adventureOpt.isPresent()) {
			return false;
		}
		Adventure adventure=adventureOpt.get();
		boolean deleted;
		client.getSubscribedAdventures().add(adventure);
		deleted=adventure.getSubscribers().add(client);
		this.adventureRepository.save(adventure);
		this.clientService.save(client);
		return deleted;
	}
}
