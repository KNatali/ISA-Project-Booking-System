package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class AdventureBehavioralRule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String rule;
	@ManyToMany(mappedBy = "rules")
	private Set<Adventure> adventures=new HashSet<>();
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
	public Set<Adventure> getAdventure() {
		return adventures;
	}
	public void setAdventure(Set<Adventure> adventures) {
		this.adventures = adventures;
	}
	
	public AdventureBehavioralRule(Long id, String rule,Set<Adventure> adventure) {
		super();
		this.id = id;
		this.rule = rule;
		this.adventures = adventure;
	}
	public AdventureBehavioralRule() {}
	
}
