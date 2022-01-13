package com.isa.ISAproject.mapper;

import com.isa.ISAproject.dto.BoatBehavioralRuleDTO;
import com.isa.ISAproject.dto.CottageBehavioralRuleDTO;
import com.isa.ISAproject.model.BoatBehavioralRule;
import com.isa.ISAproject.model.CottageBehavioralRule;

public class BoatBehavioralRuleMapper {
	public BoatBehavioralRuleMapper() {}
	
	public static BoatBehavioralRuleDTO convertToDTO(BoatBehavioralRule b) {
		BoatBehavioralRuleDTO cDTO=new BoatBehavioralRuleDTO(b.getId(),b.getRule());
		return cDTO;
	}
	
	public static BoatBehavioralRule convertFromDTO(BoatBehavioralRuleDTO dto ) {
		BoatBehavioralRule rule=new BoatBehavioralRule();
		rule.setId(dto.getId());
		rule.setRule(dto.getRule());
		return rule;
	}
}
