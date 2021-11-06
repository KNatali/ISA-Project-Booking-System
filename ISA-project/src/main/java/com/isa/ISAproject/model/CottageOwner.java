package com.isa.ISAproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class CottageOwner extends User{
	@OneToMany
	private List<Cottage> cottages;

	public List<Cottage> getCottages() {
		return cottages;
	}

	public void setCottages(List<Cottage> cottages) {
		this.cottages = cottages;
	}

	public CottageOwner(List<Cottage> cottages) {
		super();
		this.cottages = cottages;
	}
	
	public CottageOwner() {}
}
