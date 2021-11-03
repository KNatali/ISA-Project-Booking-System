package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BehavioralRule {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
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

	public BehavioralRule(Long id, String rule) {
		super();
		this.id = id;
		this.rule = rule;
	}
	
	public BehavioralRule() {}
	
}
