package com.isa.ISAproject.dto;

public class BoatBehavioralRuleDTO {
	private Long id;
	private String rule;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	
	public BoatBehavioralRuleDTO() {}
	public BoatBehavioralRuleDTO(Long id, String rule) {
		super();
		this.id = id;
		this.rule = rule;
	};
}
