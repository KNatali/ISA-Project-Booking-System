package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AddressDTO;
import com.isa.ISAproject.dto.AdventureBehavioralRuleDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureAddDTO;
import com.isa.ISAproject.dto.AdventureFishingEquipmentDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.AddressMapper;
import com.isa.ISAproject.mapper.AdventureBehavioralRuleMapper;
import com.isa.ISAproject.mapper.AdventureFishingEquipmentMapper;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureBehavioralRule;
import com.isa.ISAproject.model.AdventureFishingEquipment;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.AdditionalItemRepository;
import com.isa.ISAproject.repository.AddressRepository;
import com.isa.ISAproject.repository.AdventureFishingEquipmentRepository;
import com.isa.ISAproject.repository.AdventureRepository;
import com.isa.ISAproject.repository.InstructorRepository;
import com.isa.ISAproject.repository.BehavioralRuleRepository;
@Service
public class AdventureService {
	@Autowired
	private AdventureRepository adventureRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AdventureFishingEquipmentRepository equipmentRepository;
	@Autowired
	private AdditionalItemRepository addtitionalItemRepository;
	@Autowired
	private BehavioralRuleRepository ruleRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	
	public List<AdventureDTO> findAll(){
		List<Adventure> adventures= this.adventureRepository.findAll();
		return AdventureMapper.convertoToDTOs(adventures);
		
	}
	public AdventureDTO findById(Long id) {
		Optional<Adventure> adventure=this.adventureRepository.findById(id);
		return AdventureMapper.convertToDTO(adventure.get());
	}

	
	public void delete(Long id) {
		Adventure a=adventureRepository.getById(id);
		this.adventureRepository.delete(a);
	}
	public void addAdventure(Long instructorId, AdventureAddDTO dto) {
		Instructor instructor=instructorRepository.getById(instructorId);
		//Address address=AddressMapper.convertFromDTO(dto.getAddress());
		Address address=new Address();
		address.setStreet(dto.getAddress().getStreet());
		address.setCity(dto.getAddress().getCity());
		address.setState(dto.getAddress().getState());
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
	

}
