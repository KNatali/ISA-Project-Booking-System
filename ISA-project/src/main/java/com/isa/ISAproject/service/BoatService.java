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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.BoatAddDTO;
import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.BoatReservationCreateDTO;
import com.isa.ISAproject.dto.BoatReservationDTO;
import com.isa.ISAproject.dto.ClientProfileDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.dto.BoatBehavioralRuleDTO;
import com.isa.ISAproject.dto.NavigationEquipmentDTO;
import com.isa.ISAproject.dto.SearchAvailableBoatByPriceOrGradeDTO;
import com.isa.ISAproject.dto.SearchAvailableCottageByGradeDTO;
import com.isa.ISAproject.dto.SearchAvailableCottageByPriceDTO;
import com.isa.ISAproject.dto.SearchForReservationDTO;
import com.isa.ISAproject.dto.UnsubscribedItemDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.AdventureFishingEquipmentMapper;
import com.isa.ISAproject.mapper.BoatBehavioralRuleMapper;
import com.isa.ISAproject.mapper.BoatMapper;
import com.isa.ISAproject.mapper.CottageMapper;
import com.isa.ISAproject.mapper.NavigationEquipmentMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureFishingEquipment;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.BoatOwner;
import com.isa.ISAproject.model.BoatReservation;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.BoatBehavioralRule;
import com.isa.ISAproject.model.NavigationEquipment;
import com.isa.ISAproject.model.TimePeriod;
import com.isa.ISAproject.repository.AdditionalItemRepository;
import com.isa.ISAproject.repository.AddressRepository;
import com.isa.ISAproject.repository.BoatBehavioralRuleRepository;
import com.isa.ISAproject.repository.BoatNavigationEquipmentRepository;
import com.isa.ISAproject.repository.BoatOwnerRepository;
import com.isa.ISAproject.repository.BoatRepository;
import com.isa.ISAproject.repository.BoatReservationRepository;
import com.isa.ISAproject.repository.ClientRepository;

@Component
public class BoatService {
	@Autowired
	private BoatRepository boatRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private AdditionalItemRepository additionalItemRepository;
	@Autowired
	private BoatReservationRepository boatReservationRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ClientService clientService;
	@Autowired
	private BoatOwnerRepository boatOwnerRepository;
	@Autowired
	private BoatBehavioralRuleRepository ruleRepository;
	@Autowired
	private BoatNavigationEquipmentRepository equipmentRepository;
	
	public List<Boat> findAll(){
		List<Boat> allBoats = this.boatRepository.findAll();
		List<Boat> res = new ArrayList<>();
		for(Boat boats : allBoats)
		{
			if(!boats.isDeleted())
			{
				res.add(boats);
			}
		}
		return res;
		//return this.boatRepository.findAll();
	}
	
	public Boat deleteBoat(Long id) {
		Boat b=boatRepository.getById(id);
		b.setDeleted(true);
		this.boatRepository.save(b);
		return b;
	}
	
	public Optional<Boat> getOne(Long id) {
		return this.boatRepository.findById(id);
	}
	public List<Boat> findByMotorNumber(int motorNumber){
		return this.boatRepository.findByMotorNumber(motorNumber);
	}
	public List<Boat> findByMotorPower(double motorPower){
		return this.boatRepository.findByMotorPower(motorPower);
	}
	public List<Boat> findByMotorPowerAndMotorNumber(double motorPower, int motorNumber){
		return this.boatRepository.findByMotorPowerAndMotorNumber(motorPower,motorNumber);
	}
	public List<Boat> sortByName(){
		return this.boatRepository.findByOrderByName();
	}
	public List<Boat> sortByGrade(){
		return this.boatRepository.findByOrderByGradeDesc();
	}
	public List<Boat> sortByPrice(){
		return this.boatRepository.findByOrderByPriceDesc();
	}
	public List<Boat> sortByCity(){
		List<Boat> allBoats=this.boatRepository.findAll();
		List<Address> allAddressesSortByCities=this.addressRepository.findByOrderByCity();
		List<Boat> res=new ArrayList<>();
		for (Address address : allAddressesSortByCities) {
			for (Boat boat : allBoats) {
				if(boat.getAddress().getId().equals(address.getId())  ) {
					res.add(boat);
				}
			}
		}
		return res;
	}
	public List<AdditionalItem> findAllAdditionalItems(){
		return this.additionalItemRepository.findAll();
	}
	public List<Boat> findByName(String name){
		return this.boatRepository.findByName(name);
	}
	public List<Boat> findByCity(String city){
		List<Boat> all=this.boatRepository.findAll();
		List<Boat> res=new ArrayList<>();
		for (Boat boat : all) {
			if(boat.getAddress().getCity().equals(city)) {
				res.add(boat);
			}
		}
		return res;
	}
	
	@Cacheable( value = "boat" )
	public BoatDTO findById(Long id) {
		Boat boat=this.boatRepository.getById(id);
		return BoatMapper.convertToDTO(boat);
	}
	public void delete(Long id) {
		Boat b=boatRepository.getById(id);
		b.setDeleted(true);
		this.boatRepository.save(b);
	}
	public void addBoat(Long boatOwnerId, BoatAddDTO dto) {
		BoatOwner boatOwner=boatOwnerRepository.getById(boatOwnerId);
		Address address=new Address();
		address.setStreet(dto.getAddress().getStreet());
		address.setCity(dto.getAddress().getCity());
		address.setState(dto.getAddress().getState());
		address.setLatitude(dto.getAddress().getLatitude());
		address.setLongitude(dto.getAddress().getLongitude());
		this.addressRepository.save(address);
		Set<Boat> boats=boatOwner.getBoats();
		Set<AdditionalItem> items=new HashSet<>();
		for (AdditionalItemDTO itto : dto.getItems()) {
			AdditionalItem it=AdditionalItemMapper.convertFromDTO(itto);
			items.add(it);
		}
		this.additionalItemRepository.saveAll(items);
		Set<NavigationEquipment> equipment=NavigationEquipmentMapper.convertFromDTOs(dto.getNavigationEquipment());
		this.equipmentRepository.saveAll(equipment);
		
		Set<BoatBehavioralRule> rules=new HashSet<>();
		for (BoatBehavioralRuleDTO rdto : dto.getRules()) {
			BoatBehavioralRule b=BoatBehavioralRuleMapper.convertFromDTO(rdto);
			rules.add(b);
		}
		this.ruleRepository.saveAll(rules);
		Boat b=new Boat(dto.getId(),dto.getName(),address,dto.getType(),dto.getLength(),dto.getMotorNumber(),dto.getMotorPower(),dto.getMaxSpeed(),dto.getCapacity(),dto.getDescription(),0,dto.getPrice(),boatOwner,dto.getMainPicture(),null,dto.getMaxPersons(),rules,dto.getCancellationPercentage(),null,items,equipment,null);
		this.boatRepository.save(b);
	}
	
	public List<Boat> findByBoatOwner(BoatOwner boatOwner){
		return this.boatRepository.findByOwner(boatOwner);
	}
	
	public boolean editBoat(Long id,BoatDTO dto) {
		Boat b=boatRepository.getById(id);
		b.setName(dto.getName());
		b.getAddress().setStreet(dto.getAddress().getStreet());
		b.getAddress().setCity(dto.getAddress().getCity());
		b.getAddress().setState(dto.getAddress().getState());
		b.setMaxPersons(dto.getMaxPersons());
		b.setCancellationPercentage(dto.getCancellationPercentage());
		b.setPrice(dto.getPrice());
		b.setDescription(dto.getDescription());
		b.getOwner();
		this.boatRepository.save(b);
		return true;
	}
	
	public List<BoatBehavioralRuleDTO> getBoatRules(Long id){
		Boat boat=this.boatRepository.getById(id);
		Set<BoatBehavioralRule> list=boat.getRules();
		List<BoatBehavioralRuleDTO> listDTO=new ArrayList<>();
		for(BoatBehavioralRule b:list) { 
			BoatBehavioralRuleDTO bDTO=BoatBehavioralRuleMapper.convertToDTO(b);
			listDTO.add(bDTO);
		}
		return listDTO;
	}
	
	public List<AdditionalItemDTO> getBoatAdditionalItems(Long id){
		Boat boat=this.boatRepository.getById(id);
		Set<AdditionalItem> list=boat.getAdditionalItems();
		List<AdditionalItemDTO> listDTO=new ArrayList<>();
		for(AdditionalItem a:list) { 
			AdditionalItemDTO aDTO=AdditionalItemMapper.convertToDTO(a);
			listDTO.add(aDTO);
		}
		return listDTO;
	}
	public List<NavigationEquipmentDTO> getNavigationEquipment(Long id){
		Boat boat=this.boatRepository.getById(id);
		Set<NavigationEquipment> list=boat.getNavigationEquipment();
		List<NavigationEquipmentDTO> listDTO=new ArrayList<>();
		for(NavigationEquipment n:list) { 
			NavigationEquipmentDTO nDTO=NavigationEquipmentMapper.convertToDTO(n);
			listDTO.add(nDTO);
		}
		return listDTO;
	}
	
	public void saveNewEquipment(Long id,NavigationEquipmentDTO eDTO) {
		NavigationEquipment e=NavigationEquipmentMapper.convertFromDTO(eDTO);
		
		Boat b=boatRepository.getById(id);
		this.equipmentRepository.save(e);
		Set<NavigationEquipment> list=b.getNavigationEquipment();
		list.add(e);
		//a.setEquipment(list);
		
		this.boatRepository.save(b);
	}
	
	public boolean editEquipment(Long id,NavigationEquipmentDTO eDTO) {
		NavigationEquipment e=equipmentRepository.getById(eDTO.getId());
		NavigationEquipment edited=new NavigationEquipment();
		edited.setId(e.getId());
		edited.setName(eDTO.getName());
		this.equipmentRepository.save(edited);
		Boat b=boatRepository.getById(id);
		
		Set<NavigationEquipment> list=b.getNavigationEquipment();
		list.remove(e);
		list.add(edited);	
		return true;
	}
	
	public boolean deleteEquipment (Long boatId,Long equipmentId) {
		NavigationEquipment e=this.equipmentRepository.getById(equipmentId);
		Boat b=this.boatRepository.getById(boatId);
		if(e==null || b==null) {
			return false;
		}
		Set<NavigationEquipment> list=b.getNavigationEquipment();
		list.remove(e);
		this.equipmentRepository.delete(e);
		this.boatRepository.save(b);
		return true;		
	}

	public List<Boat> findAllAvailableBoat(SearchForReservationDTO dto){
		//treba dobaviti sve brodove
		List<Boat> boats=this.findAll();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getDateAndTime(),formatter);
		LocalDateTime end = start.plusDays(dto.getNumOfDay());
		
		List<Boat> availableBoats=new ArrayList<>();
		for (Boat boat : boats) {
			Set<TimePeriod> unavailability=boat.getUnavailability();//sve zautestosti jednog broda
			int broj_zauzetosti=unavailability.size();
			int brojac=0;//brokjim koliko yautesto se  preklapa sa zeljenim datumom
			for (TimePeriod timePeriod : unavailability) {
				if ((end.isAfter(timePeriod.getStartTime()) && end.isBefore(timePeriod.getEndTime()))||(start.isAfter(timePeriod.getStartTime()) && start.isBefore(timePeriod.getEndTime()))) {
					brojac++;
				}
			}
			if (broj_zauzetosti!=brojac || broj_zauzetosti==0) {
				availableBoats.add(boat);
			}
		}
		return availableBoats;
	}
	public List<Boat> sortByGradeAvailableBoat(List<BoatDTO> boats) {
		List<Boat> all_sorted_boats = this.sortByGrade();
		List<Boat> sorted_boats =new ArrayList<>();
		for (Boat boat : all_sorted_boats) {
			for (BoatDTO boat2 : boats) {
				if(boat.getId().equals(boat2.getId())) {
					sorted_boats.add(boat);
				}
			}
		}
		return sorted_boats;
	}
	public List<Boat> sortByPriceAvailableBoat(List<BoatDTO> boats) {
		List<Boat> all_sorted_boats = this.sortByPrice();
		List<Boat> sorted_boats =new ArrayList<>();
		for (Boat boat : all_sorted_boats) {
			for (BoatDTO boat2 : boats) {
				if(boat.getId().equals(boat2.getId())) {
					sorted_boats.add(boat);
				}
			}
		}
		return sorted_boats;
	}
	public List<BoatDTO> findAvailableByGrade(SearchAvailableBoatByPriceOrGradeDTO dto){
		List<Boat> all_boats=this.boatRepository.findByGrade(dto.getPriceOrGrade());
		List<BoatDTO> available_boatdtos=dto.getBoats();
		List<BoatDTO> all_boatsdtos=BoatMapper.convertoToDTOs(all_boats);
		List<BoatDTO> res=new ArrayList<BoatDTO>();
		
		for (BoatDTO boat : available_boatdtos) {
			for (BoatDTO boat2 : all_boatsdtos) {
				if (boat.getId().equals(boat2.getId())) {
					res.add(boat);
				}
			}
		}
		return res;
	}
	public List<BoatDTO> findAvailableByPrice(SearchAvailableBoatByPriceOrGradeDTO dto){
		List<Boat> all_boats=this.boatRepository.findByPrice(dto.getPriceOrGrade());
		List<BoatDTO> available_boatdtos=dto.getBoats();
		List<BoatDTO> all_boatsdtos=BoatMapper.convertoToDTOs(all_boats);
		List<BoatDTO> res=new ArrayList<BoatDTO>();
		
		for (BoatDTO boat : available_boatdtos) {
			for (BoatDTO boat2 : all_boatsdtos) {
				if (boat.getId().equals(boat2.getId())) {
					res.add(boat);
				}
			}
		}
		return res;
	}
	public List<BoatDTO> getALlSubscribedBoats(Long clientId){
		Optional<Client> opt=this.clientService.findById(clientId);
		if(!opt.isPresent()) {
			return null;
		}
		Client client=opt.get();
		Set<Boat> subscribed=client.getSubscribedBoats();
		List<Boat> list_subscribed=new ArrayList<Boat>();
		for (Boat boat : subscribed) {
			list_subscribed.add(boat);
		}
		return BoatMapper.convertoToDTOs(list_subscribed);
	}
	public boolean subscribedBoat(UnsubscribedItemDTO dto) {
		Optional<Client> opt=this.clientService.findById(dto.getClientId());
		if(!opt.isPresent()) {
			return false;
		}
		Client client=opt.get();
		
		Optional<Boat> boatopt=this.boatRepository.findById(dto.getEntityId());
		if(!boatopt.isPresent()) {
			return false;
		}
		Boat boat=boatopt.get();
		boolean deleted;
		client.getSubscribedBoats().add(boat);
		deleted=boat.getSubscribers().add(client);
		this.boatRepository.save(boat);
		this.clientService.save(client);
		return deleted;
	}
	
	public boolean unsubscribedBoat(UnsubscribedItemDTO dto){
		Optional<Client> opt=this.clientService.findById(dto.getClientId());
		if(!opt.isPresent()) {
			return false;
		}
		Client client=opt.get();
		
		Optional<Boat> boatopt=this.boatRepository.findById(dto.getEntityId());
		if(!boatopt.isPresent()) {
			return false;
		}
		Boat boat=boatopt.get();
		boolean deleted;
		client.getSubscribedBoats().remove(boat);
		deleted=boat.getSubscribers().remove(client);
		this.boatRepository.save(boat);
		this.clientService.save(client);
		return deleted;
	}
}
