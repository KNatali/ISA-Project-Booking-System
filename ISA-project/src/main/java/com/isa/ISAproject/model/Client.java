package com.isa.ISAproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Client extends User{
	@OneToMany
	private List<AdventureReservation> adventureReservations;
	@OneToMany
	private List<BoatReservation> boatReservations;
	@OneToMany
	private List<CottageReservation> cottageReservations;
	public List<AdventureReservation> getAdventureReservations() {
		return adventureReservations;
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
}
