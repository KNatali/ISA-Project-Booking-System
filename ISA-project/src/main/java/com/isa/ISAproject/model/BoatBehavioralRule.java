package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class BoatBehavioralRule {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String rule;
	
	@ManyToMany
	private Set<Boat> boats=new HashSet<>();

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

	public Set<Boat> getBoat() {
		return boats;
	}

	public void setBoat(Set<Boat> boats) {
		this.boats = boats;
	}

	public BoatBehavioralRule(Long id, String rule, Set<Boat> boats) {
		super();
		this.id = id;
		this.rule = rule;
		this.boats = boats;
	}
	
	public BoatBehavioralRule () {}
}
