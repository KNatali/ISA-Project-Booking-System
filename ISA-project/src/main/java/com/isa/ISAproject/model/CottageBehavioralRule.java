package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CottageBehavioralRule {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String rule;
	
	@ManyToOne
	private Cottage cottage;

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

	public Cottage getCottage() {
		return cottage;
	}

	public void setCottage(Cottage cottage) {
		this.cottage = cottage;
	}

	public CottageBehavioralRule(Long id, String rule, Cottage cottage) {
		super();
		this.id = id;
		this.rule = rule;
		this.cottage = cottage;
	}

	public CottageBehavioralRule() {}
	
}
