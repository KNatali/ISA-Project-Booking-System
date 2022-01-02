package com.isa.ISAproject.mapper;

import com.isa.ISAproject.dto.CottageBehavioralRuleDTO;
import com.isa.ISAproject.model.CottageBehavioralRule;

public class CottageBehavioralRuleMapper {
	public CottageBehavioralRuleMapper() {}
	
	public static CottageBehavioralRuleDTO convertToDTO(CottageBehavioralRule c) {
		CottageBehavioralRuleDTO cDTO=new CottageBehavioralRuleDTO(c.getId(),c.getRule());
		return cDTO;
	}
	
	public static CottageBehavioralRule convertFromDTO(CottageBehavioralRuleDTO dto ) {
		CottageBehavioralRule rule=new CottageBehavioralRule();
		rule.setId(dto.getId());
		rule.setRule(dto.getRule());
		return rule;
	}
}
