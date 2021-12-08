package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class CottageOwner extends User{
	
	@OneToMany(mappedBy="owner",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<Cottage> cottages=new HashSet<>();

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
	
	
}
