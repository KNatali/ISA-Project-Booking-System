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
import com.isa.ISAproject.dto.AdventureBehavioralRuleDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.BoatDTO;
import com.isa.ISAproject.dto.CottageAddDTO;
import com.isa.ISAproject.dto.CottageBehavioralRuleDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.dto.SearchAvailableAdventureByGradeDTO;
import com.isa.ISAproject.dto.SearchAvailableAdventureByPriceDTO;
import com.isa.ISAproject.dto.SearchAvailableCottageByGradeDTO;
import com.isa.ISAproject.dto.SearchAvailableCottageByPriceDTO;
import com.isa.ISAproject.dto.SearchForReservationDTO;
import com.isa.ISAproject.dto.UnsubscribedItemDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.AdventureBehavioralRuleMapper;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.mapper.CottageBehavioralRuleMapper;
import com.isa.ISAproject.mapper.CottageMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureBehavioralRule;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.Client;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.CottageBehavioralRule;
import com.isa.ISAproject.model.CottageOwner;
import com.isa.ISAproject.model.CottageReservation;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.model.TimePeriod;
import com.isa.ISAproject.repository.AdditionalItemRepository;
import com.isa.ISAproject.repository.AddressRepository;
import com.isa.ISAproject.repository.ClientRepository;
import com.isa.ISAproject.repository.CottageBehavioralRuleRepository;
import com.isa.ISAproject.repository.CottageOwnerRepository;
import com.isa.ISAproject.repository.CottageRepository;
import com.isa.ISAproject.repository.CottageReservationRepository;

@Service
public class CottageService {
	@Autowired
	private CottageRepository cottageRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CottageOwnerRepository cottageOwnerRepository;
	@Autowired
	private CottageBehavioralRuleRepository ruleRepository;
	@Autowired
	private AdditionalItemRepository addtitionalItemRepository;
	@Autowired
	private CottageReservationRepository cottageReservationRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ClientService clientService;
	
	public List<Cottage> findAll() {
		return this.cottageRepository.findAll();
	}
	@Cacheable( value = "cottage" )
	public CottageDTO findById(Long id) {
		Optional<Cottage> cottage=this.cottageRepository.findById(id);
		return CottageMapper.convertToDTO(cottage.get());
	}
	public void delete(Long id) {
		Cottage b=cottageRepository.getById(id);
		b.setDeleted(true);
		this.cottageRepository.save(b);
	}
	public Optional<Cottage> getOne(Long id) {
		return this.cottageRepository.findById(id);
	}
	public List<Cottage> findByName(String name) {
		return this.cottageRepository.findByName(name);
	}
	public List<Cottage> findByAddress(String address){
		return this.cottageRepository.findByAddress(address);
	}
	public List<Cottage> sortByName(){
		return this.cottageRepository.findByOrderByName();
	}
	public List<Cottage> sortByGrade(){
		return this.cottageRepository.findByOrderByGradeDesc();
	}
	public List<Cottage> sortByCity(){
		List<Cottage> allCottages=this.cottageRepository.findAll();
		List<Address> allAddressesSortByCities=this.addressRepository.findByOrderByCity();
		List<Cottage> res=new ArrayList<>();
		for (Address address : allAddressesSortByCities) {
			for (Cottage cottage : allCottages) {
				if(cottage.getAddress().getId().equals(address.getId())  ) {
					res.add(cottage);
				}
			}
		}
		return res;
	}
	public List<Cottage> findByCity(String city){
		List<Cottage> allCottages=this.cottageRepository.findAll();
		List<Cottage> res=new ArrayList<>();
		for (Cottage cottage : allCottages) {
			if(cottage.getAddress().getCity().equals(city)) {
				res.add(cottage);
			}
		}
		return res;
	}
	public void addCottage(Long cottageOwnerId, CottageAddDTO dto) {
		CottageOwner cottageOwner=cottageOwnerRepository.getById(cottageOwnerId);
		Address address=new Address();
		address.setStreet(dto.getAddress().getStreet());
		address.setCity(dto.getAddress().getCity());
		address.setState(dto.getAddress().getState());
		address.setLatitude(dto.getAddress().getLatitude());
		address.setLongitude(dto.getAddress().getLongitude());
		this.addressRepository.save(address);
		Set<Cottage> cottages=cottageOwner.getCottages();
		Set<AdditionalItem> items=new HashSet<>();
		for (AdditionalItemDTO itto : dto.getItems()) {
			AdditionalItem it=AdditionalItemMapper.convertFromDTO(itto);
			items.add(it);
		}
		this.addtitionalItemRepository.saveAll(items);
		Set<CottageBehavioralRule> rules=new HashSet<>();
		for (CottageBehavioralRuleDTO rdto : dto.getRules()) {
			CottageBehavioralRule c=CottageBehavioralRuleMapper.convertFromDTO(rdto);
			rules.add(c);
		}
		this.ruleRepository.saveAll(rules);
		Cottage c=new Cottage(dto.getId(),dto.getName(),address,dto.getDescription(),0,dto.getPrice(),cottageOwner,dto.getMainPicture(),null,dto.getMaxPersons(),rules,dto.getCancellationPercentage(),null,items,null);
		this.cottageRepository.save(c);
	}
	
	public List<Cottage> findByCottageOwner(CottageOwner cottageOwner){
		return this.cottageRepository.findByCottageOwner(cottageOwner);
	}
	
	public boolean editCottage(Long id,CottageDTO dto) {
		Cottage c=cottageRepository.getById(id);
		c.setName(dto.getName());
		c.getAddress().setStreet(dto.getAddress().getStreet());
		c.getAddress().setCity(dto.getAddress().getCity());
		c.getAddress().setState(dto.getAddress().getState());
		c.setMaxPersons(dto.getMaxPersons());
		c.setCancellationPercentage(dto.getCancellationPercentage());
		c.setPrice(dto.getPrice());
		c.setDescription(dto.getDescription());
		c.getCottageOwner();
		this.cottageRepository.save(c);
		return true;
	}
	
	public List<CottageBehavioralRuleDTO> getCottageRules(Long id){
		Optional<Cottage> cottage=this.cottageRepository.findById(id);
		Set<CottageBehavioralRule> list=cottage.get().getRules();
		List<CottageBehavioralRuleDTO> listDTO=new ArrayList<>();
		for(CottageBehavioralRule c:list) { 
			CottageBehavioralRuleDTO cDTO=CottageBehavioralRuleMapper.convertToDTO(c);
			listDTO.add(cDTO);
		}
		return listDTO;
	}
	
	public List<AdditionalItemDTO> getCottageAdditionalItems(Long id){
		Optional<Cottage> cottage=this.cottageRepository.findById(id);
		Set<AdditionalItem> list=cottage.get().getItems();
		List<AdditionalItemDTO> listDTO=new ArrayList<>();
		for(AdditionalItem a:list) { 
			AdditionalItemDTO aDTO=AdditionalItemMapper.convertToDTO(a);
			listDTO.add(aDTO);
		}
		return listDTO;
	}

	public List<Cottage> findAllAvailableCottage(SearchForReservationDTO dto){
		//treba dobaviti sve brodove
		List<Cottage> cottages=this.findAll();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime start = LocalDateTime.parse(dto.getDateAndTime(),formatter);
		LocalDateTime end = start.plusDays(dto.getNumOfDay());

		List<Cottage> availableCottages=new ArrayList<>();
		for (Cottage cottage : cottages) {
			Set<TimePeriod> unavailability=cottage.getUnavailability();//sve zautestosti jednog broda
			int broj_zauzetosti=unavailability.size();
			int brojac=0;//brokjim koliko yautesto se  preklapa sa zeljenim datumom
			for (TimePeriod timePeriod : unavailability) {
				if ((end.isAfter(timePeriod.getStartTime()) && end.isBefore(timePeriod.getEndTime()))||(start.isAfter(timePeriod.getStartTime()) && start.isBefore(timePeriod.getEndTime()))) {
					brojac++;
				}
			}
			if (broj_zauzetosti!=brojac || broj_zauzetosti==0) {
				availableCottages.add(cottage);
			}
		}
		return availableCottages;
	}
	public List<Cottage> sortByGradeAvailableCottage(List<CottageDTO> cottages) {
		List<Cottage> all_sorted_cottages = this.sortByGrade();
		List<Cottage> sorted_cottages =new ArrayList<>();
		for (Cottage boat : all_sorted_cottages) {
			for (CottageDTO boat2 : cottages) {
				if(boat.getId()==boat2.getId()) {
					sorted_cottages.add(boat);
				}
			}
		}
		return sorted_cottages;
	}
	
	public List<Cottage> sortByPriceAvailableCottage(List<CottageDTO> cottages) {
		List<Cottage> all_sorted_cottages = this.cottageRepository.findByOrderByPriceDesc();
		List<Cottage> sorted_cottages =new ArrayList<>();
		for (Cottage cottage : all_sorted_cottages) {
			for (CottageDTO cottage2 : cottages) {
				if(cottage.getId()==cottage2.getId()) {
					sorted_cottages.add(cottage);
				}
			}
		}
		return sorted_cottages;
	}
	public List<CottageDTO> findAvailableByGrade(SearchAvailableCottageByGradeDTO dto){
		List<Cottage> all_cottages=this.cottageRepository.findByGrade(dto.getGrade());
		List<CottageDTO> available_cottagedtos=dto.getCottages();
		List<CottageDTO> all_cottagesdtos=CottageMapper.convertoToDTOs(all_cottages);
		List<CottageDTO> res=new ArrayList<CottageDTO>();
		
		for (CottageDTO cottage : available_cottagedtos) {
			for (CottageDTO cottage2 : all_cottagesdtos) {
				if (cottage.getId()==cottage2.getId()) {
					res.add(cottage);
				}
			}
		}
		return res;
	}
	public List<CottageDTO> findAvailableByPrice(SearchAvailableCottageByPriceDTO dto){
		List<Cottage> all_cottages=this.cottageRepository.findByPrice(dto.getPrice());
		List<CottageDTO> available_cottagedtos=dto.getCottages();
		List<CottageDTO> all_cottagesdtos=CottageMapper.convertoToDTOs(all_cottages);
		List<CottageDTO> res=new ArrayList<CottageDTO>();
		
		for (CottageDTO cottage : available_cottagedtos) {
			for (CottageDTO cottage2 : all_cottagesdtos) {
				if (cottage.getId()==cottage2.getId()) {
					res.add(cottage);
				}
			}
		}
		return res;
	}
	public List<CottageDTO> getAllSubscribedCottages(Long clientId){
		Optional<Client> opt=this.clientService.findById(clientId);
		if(!opt.isPresent()) {
			return null;
		}
		Client client=opt.get();
		Set<Cottage> subscribed=client.getSubscribedCottages();
		List<Cottage> list_subscribed=new ArrayList<Cottage>();
		for (Cottage cot : subscribed) {
			list_subscribed.add(cot);
		}
		return CottageMapper.convertoToDTOs(list_subscribed);
	}
	public boolean unsubscribedCottage(UnsubscribedItemDTO dto){
		Optional<Client> opt=this.clientService.findById(dto.getClientId());
		if(!opt.isPresent()) {
			return false;
		}
		Client client=opt.get();

		Optional<Cottage> cottageopt=this.cottageRepository.findById(dto.getEntityId());
		if(!cottageopt.isPresent()) {
			return false;
		}
		Cottage cottage=cottageopt.get();
		boolean deleted;
		client.getSubscribedCottages().remove(cottage);
		deleted=cottage.getSubscribers().remove(client);
		this.cottageRepository.save(cottage);
		this.clientService.save(client);
		return deleted;
	}
	public boolean subscribe(UnsubscribedItemDTO dto){
		Optional<Client> opt=this.clientService.findById(dto.getClientId());
		if(!opt.isPresent()) {
			return false;
		}
		Client client=opt.get();

		Optional<Cottage> cottageopt=this.cottageRepository.findById(dto.getEntityId());
		if(!cottageopt.isPresent()) {
			return false;
		}
		Cottage cottage=cottageopt.get();
		boolean deleted;
		client.getSubscribedCottages().add(cottage);
		deleted=cottage.getSubscribers().add(client);
		this.cottageRepository.save(cottage);
		this.clientService.save(client);
		return deleted;
	}
}
