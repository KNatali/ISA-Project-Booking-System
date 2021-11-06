package com.isa.ISAproject.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class AdventurePriceList {
	@Id
	@GeneratedValue
	private Long id;
	@OneToMany
	private List<AdditionalItem> additionalItems;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<AdditionalItem> getAdditionalItems() {
		return additionalItems;
	}
	public void setAdditionalItems(List<AdditionalItem> additionalItems) {
		this.additionalItems = additionalItems;
	}
	public AdventurePriceList(Long id, List<AdditionalItem> additionalItems) {
		super();
		this.id = id;
		this.additionalItems = additionalItems;
	}
	
	public AdventurePriceList () {}
}
