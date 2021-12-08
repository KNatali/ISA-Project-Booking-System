package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class BoatOwner extends User {

	@OneToMany(mappedBy="owner",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Boat> boats=new HashSet<>();

	public Set<Boat> getBoats() {
		return boats;
	}

	public void setBoats(Set<Boat> boats) {
		this.boats = boats;
	}

	public BoatOwner(Set<Boat> boats) {
		super();
		this.boats = boats;
	}
	public BoatOwner () {}

	public BoatOwner(Long id, String username, String password, String email, String firstName, String lastName,
			Address address, String mobile, boolean enabled, String role, List<Authority> authorities,Set<Boat> boats) {
		super(id, username, password, email, firstName, lastName, address, mobile, enabled, role, authorities);
		this.boats=boats;
	}

	public BoatOwner(String username, String password, String email, String firstName, String lastName, Address address,
			String mobile, boolean enabled, String role, List<Authority> authorities,Set<Boat> boats) {
		super(username, password, email, firstName, lastName, address, mobile, enabled, role, authorities);
		this.boats=boats;
	}
	
	
}
