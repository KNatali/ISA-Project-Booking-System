package com.isa.ISAproject.mapper;

import com.isa.ISAproject.dto.AdventureBehavioralRuleDTO;
import com.isa.ISAproject.model.AdventureBehavioralRule;

public class AdventureBehavioralRuleMapper {

	public AdventureBehavioralRuleMapper() {}
	
	public static AdventureBehavioralRuleDTO convertToDTO(AdventureBehavioralRule a) {
		AdventureBehavioralRuleDTO aDTO=new AdventureBehavioralRuleDTO(a.getId(),a.getRule());
		return aDTO;
	}
}