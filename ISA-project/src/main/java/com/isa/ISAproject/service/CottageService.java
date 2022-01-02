package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AdventureBehavioralRuleDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.CottageAddDTO;
import com.isa.ISAproject.dto.CottageBehavioralRuleDTO;
import com.isa.ISAproject.dto.CottageDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.AdventureBehavioralRuleMapper;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.mapper.CottageBehavioralRuleMapper;
import com.isa.ISAproject.mapper.CottageMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureBehavioralRule;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.CottageBehavioralRule;
import com.isa.ISAproject.model.CottageOwner;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.AdditionalItemRepository;
import com.isa.ISAproject.repository.AddressRepository;
import com.isa.ISAproject.repository.CottageBehavioralRuleRepository;
import com.isa.ISAproject.repository.CottageOwnerRepository;
import com.isa.ISAproject.repository.CottageRepository;

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
	
	public List<Cottage> findAll() {
		return this.cottageRepository.findAll();
	}
	public CottageDTO findById(Long id) {
		Optional<Cottage> cottage=this.cottageRepository.findById(id);
		return CottageMapper.convertToDTO(cottage.get());
	}
	public void delete(Long id) {
		Cottage c=cottageRepository.getById(id);
		this.cottageRepository.delete(c);
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
		Cottage c=new Cottage(dto.getId(),dto.getName(),address,dto.getDescription(),0,dto.getPrice(),cottageOwner,"",null,dto.getMaxPersons(),rules,dto.getCancellationPercentage(),null,items,null);
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
}
