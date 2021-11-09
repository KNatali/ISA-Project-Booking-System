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
public class CottageBehavioralRule {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String rule;
	
	@ManyToMany(mappedBy="rules")
	private Set<Cottage> cottages=new HashSet<>();

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

	public Set<Cottage> getCottage() {
		return cottages;
	}

	public void setCottage(Set<Cottage> cottages) {
		this.cottages = cottages;
	}

	public CottageBehavioralRule(Long id, String rule, Set<Cottage> cottages) {
		super();
		this.id = id;
		this.rule = rule;
		this.cottages = cottages;
	}

	public CottageBehavioralRule() {}
	
}
