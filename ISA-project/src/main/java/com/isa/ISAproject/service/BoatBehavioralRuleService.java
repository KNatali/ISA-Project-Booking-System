package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.BoatBehavioralRuleDTO;
import com.isa.ISAproject.mapper.BoatBehavioralRuleMapper;
import com.isa.ISAproject.model.Boat;
import com.isa.ISAproject.model.BoatBehavioralRule;
import com.isa.ISAproject.repository.BoatBehavioralRuleRepository;
import com.isa.ISAproject.repository.BoatRepository;



@Service
public class BoatBehavioralRuleService {
	@Autowired
	private BoatRepository boatRepository;
	@Autowired
	private BoatBehavioralRuleRepository boatBehavioralRuleRepository;
	
	public List<BoatBehavioralRuleDTO> getBoatBehavioralRules(Long id){
		Boat boat=this.boatRepository.getById(id);
		Set<BoatBehavioralRule> list=boat.getRules();
		List<BoatBehavioralRuleDTO> listDTO=new ArrayList<>();
		for(BoatBehavioralRule b:list) { 
			BoatBehavioralRuleDTO bDTO=BoatBehavioralRuleMapper.convertToDTO(b);
			listDTO.add(bDTO);
		}
		return listDTO;
	}
	
	public void saveNewBehavioralRule(Long id,BoatBehavioralRuleDTO eDTO) {
		BoatBehavioralRule e=BoatBehavioralRuleMapper.convertFromDTO(eDTO);
		Boat b=boatRepository.getById(id);
		this.boatBehavioralRuleRepository.save(e);
		Set<BoatBehavioralRule> list=b.getRules();
		list.add(e);
		this.boatRepository.save(b);
	}
	
	public boolean editBehavioralRule(Long id,BoatBehavioralRuleDTO eDTO) {
		BoatBehavioralRule e=boatBehavioralRuleRepository.getById(eDTO.getId());
		BoatBehavioralRule edited=new BoatBehavioralRule();
		edited.setId(e.getId());
		edited.setRule(eDTO.getRule());
		this.boatBehavioralRuleRepository.save(edited);
		Boat b=boatRepository.getById(id);
		Set<BoatBehavioralRule> list=b.getRules();
		list.remove(e);
		list.add(edited);
		return true;
	}
}
