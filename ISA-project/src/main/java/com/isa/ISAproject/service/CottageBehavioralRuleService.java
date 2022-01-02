package com.isa.ISAproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.ISAproject.dto.CottageBehavioralRuleDTO;
import com.isa.ISAproject.mapper.CottageBehavioralRuleMapper;
import com.isa.ISAproject.model.Cottage;
import com.isa.ISAproject.model.CottageBehavioralRule;
import com.isa.ISAproject.repository.CottageBehavioralRuleRepository;
import com.isa.ISAproject.repository.CottageRepository;


@Service
public class CottageBehavioralRuleService {
	@Autowired
	private CottageRepository cottageRepository;
	@Autowired
	private CottageBehavioralRuleRepository cottageBehavioralRuleRepository;
	
	public List<CottageBehavioralRuleDTO> getCottageBehavioralRules(Long id){
		Optional<Cottage> cottage=this.cottageRepository.findById(id);
		Set<CottageBehavioralRule> list=cottage.get().getRules();
		List<CottageBehavioralRuleDTO> listDTO=new ArrayList<>();
		for(CottageBehavioralRule c:list) { 
			CottageBehavioralRuleDTO cDTO=CottageBehavioralRuleMapper.convertToDTO(c);
			listDTO.add(cDTO);
		}
		return listDTO;
	}
	
	public void saveNewBehavioralRule(Long id,CottageBehavioralRuleDTO eDTO) {
		CottageBehavioralRule e=CottageBehavioralRuleMapper.convertFromDTO(eDTO);
		Cottage c=cottageRepository.getById(id);
		this.cottageBehavioralRuleRepository.save(e);
		Set<CottageBehavioralRule> list=c.getRules();
		list.add(e);
		this.cottageRepository.save(c);
	}
	
	public boolean editBehavioralRule(Long id,CottageBehavioralRuleDTO eDTO) {
		CottageBehavioralRule e=cottageBehavioralRuleRepository.getById(eDTO.getId());
		CottageBehavioralRule edited=new CottageBehavioralRule();
		edited.setId(e.getId());
		edited.setRule(eDTO.getRule());
		this.cottageBehavioralRuleRepository.save(edited);
		Cottage c=cottageRepository.getById(id);
		Set<CottageBehavioralRule> list=c.getRules();
		list.remove(e);
		list.add(edited);
		return true;
	}
}
