package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class BoatOwner extends AppUser {

	@Column
	private double grade;
	@OneToMany(mappedBy="owner",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Boat> boats=new HashSet<>();
	@ManyToMany(cascade =CascadeType.ALL)
	 @JoinTable(
	            name = "boatOwner_unavailability",
	            joinColumns = @JoinColumn(name = "boatOwner_id"),
	            inverseJoinColumns = @JoinColumn(name = "period_id"))
	private Set<TimePeriod> unavailability;

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
	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	public Set<TimePeriod> getUnavailability() {
		return unavailability;
	}

	public void setUnavailability(Set<TimePeriod> unavailability) {
		this.unavailability = unavailability;
	}
	public BoatOwner () {}

	public BoatOwner(Long id, String username, String password, String email, String firstName, String lastName,
			Address address, String mobile, boolean enabled, String role, List<Authority> authorities,Set<Boat> boats, double grade) {
		super(id, username, password, email, firstName, lastName, address, mobile, enabled, role, authorities);
		this.boats=boats;
		this.grade=grade;
	}

	public BoatOwner(String username, String password, String email, String firstName, String lastName, Address address,
			String mobile, boolean enabled, String role, List<Authority> authorities,Set<Boat> boats) {
		super(username, password, email, firstName, lastName, address, mobile, enabled, role, authorities);
		this.boats=boats;
	}
	
	
}
