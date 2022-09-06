package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.AdventureBehavioralRuleDTO;
import com.isa.ISAproject.mapper.AdventureBehavioralRuleMapper;
import com.isa.ISAproject.model.Adventure;
import com.isa.ISAproject.model.AdventureBehavioralRule;
import com.isa.ISAproject.repository.AdventureRepository;
import com.isa.ISAproject.repository.BehavioralRuleRepository;

@Service
public class AdventureBehavioralRuleService {

	@Autowired
	private AdventureRepository adventureRepository;
	@Autowired
	private BehavioralRuleRepository behavioralRuleRepository;
	
	public List<AdventureBehavioralRuleDTO> getAdventureBehavioralRules(Long id){
		Adventure adventure=this.adventureRepository.getById(id);
		Set<AdventureBehavioralRule> list=adventure.getRules();
		List<AdventureBehavioralRuleDTO> listDTO=new ArrayList<>();
		for(AdventureBehavioralRule a:list) { 
			AdventureBehavioralRuleDTO aDTO=AdventureBehavioralRuleMapper.convertToDTO(a);
			listDTO.add(aDTO);
		}
		return listDTO;
	}
	
	public void saveNewBehavioralRule(Long id,AdventureBehavioralRuleDTO eDTO) {
		AdventureBehavioralRule e=AdventureBehavioralRuleMapper.convertFromDTO(eDTO);
		Adventure a=adventureRepository.getById(id);
		this.behavioralRuleRepository.save(e);
		Set<AdventureBehavioralRule> list=a.getRules();
		list.add(e);
		
		this.adventureRepository.save(a);
		
		
	}
	
	public boolean editBehavioralRule(Long id,AdventureBehavioralRuleDTO eDTO) {
		AdventureBehavioralRule e=behavioralRuleRepository.getById(eDTO.getId());
		AdventureBehavioralRule edited=new AdventureBehavioralRule();
		edited.setId(e.getId());
		edited.setRule(eDTO.getRule());
		this.behavioralRuleRepository.save(edited);
		Adventure a=adventureRepository.getById(id);
		
		Set<AdventureBehavioralRule> list=a.getRules();
	list.remove(e);
	list.add(edited);
			
		
		
		return true;
	}
}
