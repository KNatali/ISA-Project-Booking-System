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
public class CottageOwner extends User{
	
	@Column
	private double grade;
	@OneToMany(mappedBy="cottageOwner",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Cottage> cottages=new HashSet<>();
	@ManyToMany(cascade =CascadeType.ALL)
	 @JoinTable(
	            name = "cottageOwner_unavailability",
	            joinColumns = @JoinColumn(name = "cottageOwner_id"),
	            inverseJoinColumns = @JoinColumn(name = "period_id"))
	private Set<TimePeriod> unavailability;

	public Set<Cottage> getCottages() {
		return cottages;
	}

	public void setCottages(Set<Cottage> cottages) {
		this.cottages = cottages;
	}

	public CottageOwner(Set<Cottage> cottages) {
		super();
		this.cottages = cottages;
	}
	
	public Set<TimePeriod> getUnavailability() {
		return unavailability;
	}

	public void setUnavailability(Set<TimePeriod> unavailability) {
		this.unavailability = unavailability;
	}
	
	public CottageOwner() {}

	public CottageOwner(Long id, String username, String password, String email, String firstName, String lastName,
			Address address, String mobile, boolean enabled, String role, List<Authority> authorities,Set<Cottage> cottages) {
		super(id, username, password, email, firstName, lastName, address, mobile, enabled, role, authorities);
		this.cottages=cottages;
	}

	public CottageOwner(String username, String password, String email, String firstName, String lastName,
			Address address, String mobile, boolean enabled, String role, List<Authority> authorities,Set<Cottage> cottages) {
		super(username, password, email, firstName, lastName, address, mobile, enabled, role, authorities);
		this.cottages=cottages;
	}
	
	public CottageOwner(Long id, String username, String password, String email, String firstName, String lastName,
			Address address, String mobile, boolean enabled, String role, List<Authority> authorities,double grade,Set<Cottage> cottages) {
		super(id, username, password, email, firstName, lastName, address, mobile, enabled, role, authorities);
		this.grade=grade;
		this.cottages=cottages;
	}
}
