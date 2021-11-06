package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BoatBehavioralRule {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String rule;
	
	@ManyToOne
	private Boat boat;

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

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	public BoatBehavioralRule(Long id, String rule, Boat boat) {
		super();
		this.id = id;
		this.rule = rule;
		this.boat = boat;
	}
	
	public BoatBehavioralRule () {}
}
