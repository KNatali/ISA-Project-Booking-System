package com.isa.ISAproject.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Client extends AppUser{
	@Column
	private int numberOfPenals=0;
	@OneToMany (cascade = CascadeType.ALL,orphanRemoval = true)
	private List<AdventureReservation> adventureReservations;
	@OneToMany
	private List<BoatReservation> boatReservations;
	@OneToMany
	private List<CottageReservation> cottageReservations;
	@ManyToMany(mappedBy = "subscribers")
	private Set<Adventure> subscribedAdventures=new HashSet<>();
	@ManyToMany(mappedBy = "subscribers")
	private Set<Cottage> subscribedCottages=new HashSet<>();
	
	public List<AdventureReservation> getAdventureReservations() {
		return adventureReservations;
		
	}
	
	
	public Set<Adventure> getSubscribedAdventures() {
		return subscribedAdventures;
	}


	public void setSubscribedAdventures(Set<Adventure> subscribedAdventures) {
		this.subscribedAdventures = subscribedAdventures;
	}


	public int getNumberOfPenals() {
		return numberOfPenals;
	}

	public void setNumberOfPenals(int numberOfPenals) {
		this.numberOfPenals = numberOfPenals;
	}

	public void setAdventureReservations(List<AdventureReservation> adventureReservations) {
		this.adventureReservations = adventureReservations;
	}
	public List<BoatReservation> getBoatReservations() {
		return boatReservations;
	}
	public void setBoatReservations(List<BoatReservation> boatReservations) {
		this.boatReservations = boatReservations;
	}
	public List<CottageReservation> getCottageReservations() {
		return cottageReservations;
	}
	public void setCottageReservations(List<CottageReservation> cottageReservations) {
		this.cottageReservations = cottageReservations;
	}
	
	public Client() {}
	public Client(String username, String password, String email, String firstName, String lastName,
			Address address, String mobile, boolean enabled, String role, List<Authority> authorities) {
		super();
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setMobile(mobile);
		setEnabled(enabled);
		setRole(role);
		setAuthorities(authorities);
	}
}
