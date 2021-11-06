package com.isa.ISAproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Instructor extends User{
	@OneToMany
	private List<Adventure> adventures;

	public List<Adventure> getAdventures() {
		return adventures;
	}

	public void setAdventures(List<Adventure> adventures) {
		this.adventures = adventures;
	}

	public Instructor(List<Adventure> adventures) {
		super();
		this.adventures = adventures;
	}
	
	public Instructor() {}
}
