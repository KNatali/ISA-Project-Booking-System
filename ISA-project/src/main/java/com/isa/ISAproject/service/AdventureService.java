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
import com.isa.ISAproject.repository.AdventureRepository;

@Service
public class AdventureService {
	@Autowired
	private AdventureRepository adventureRepository;
	
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
