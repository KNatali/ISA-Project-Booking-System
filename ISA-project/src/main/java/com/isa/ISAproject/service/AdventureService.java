package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdditionalItemDTO;
import com.isa.ISAproject.dto.AddressDTO;
import com.isa.ISAproject.dto.AdventureBehavioralRuleDTO;
import com.isa.ISAproject.dto.AdventureDTO;
import com.isa.ISAproject.dto.AdventureFishingEquipmentDTO;
import com.isa.ISAproject.dto.InstructorProfileDTO;
import com.isa.ISAproject.mapper.AdditionalItemMapper;
import com.isa.ISAproject.mapper.AdventureBehavioralRuleMapper;
import com.isa.ISAproject.mapper.AdventureFishingEquipmentMapper;
import com.isa.ISAproject.mapper.AdventureMapper;
import com.isa.ISAproject.model.AdditionalItem;
import com.isa.ISAproject.model.Address;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureBehavioralRule;
import com.isa.ISAproject.model.AdventureFishingEquipment;
import com.isa.ISAproject.model.Instructor;
import com.isa.ISAproject.repository.AdventureFishingEquipmentRepository;
import com.isa.ISAproject.repository.AdventureRepository;

@Service
public class AdventureService {
	@Autowired
	private AdventureRepository adventureRepository;
	
	@Autowired
	private AdventureFishingEquipmentRepository equipmentRepository;
	
	public List<AdventureDTO> findAll(){
		List<Adventure> adventures= this.adventureRepository.findAll();
		return AdventureMapper.convertoToDTOs(adventures);
		
	}
	public AdventureDTO findById(Long id) {
		Optional<Adventure> adventure=this.adventureRepository.findById(id);
		return AdventureMapper.convertToDTO(adventure.get());
	}

	
	public void delete(Long id) {
		this.adventureRepository.deleteById(id);
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
	

}
