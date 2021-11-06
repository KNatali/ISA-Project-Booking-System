package com.isa.ISAproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class BoatOwner extends User {
	@OneToMany
	private List<Boat> boats;

	public List<Boat> getBoats() {
		return boats;
	}

	public void setBoats(List<Boat> boats) {
		this.boats = boats;
	}

	public BoatOwner(List<Boat> boats) {
		super();
		this.boats = boats;
	}
	public BoatOwner () {}
}
