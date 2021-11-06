package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AdventureBehavioralRule {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String rule;
	@ManyToOne
	private Adventure adventure;
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
	public Adventure getAdventure() {
		return adventure;
	}
	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}
	
	public AdventureBehavioralRule(Long id, String rule, Adventure adventure) {
		super();
		this.id = id;
		this.rule = rule;
		this.adventure = adventure;
	}
	public AdventureBehavioralRule() {}
	
}
