package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class AdventureComplaint {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String description;
	@ManyToOne
	private Client client;
	@ManyToOne
	private AdventureReservation adventureReservation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public AdventureReservation getAdventureReservation() {
		return adventureReservation;
	}
	public void setAdventureReservation(AdventureReservation adventureReservation) {
		this.adventureReservation = adventureReservation;
	}
	public AdventureComplaint(Long id, String description, Client client, AdventureReservation adventureReservation) {
		super();
		this.id = id;
		this.description = description;
		this.client = client;
		this.adventureReservation = adventureReservation;
	}
	
	public AdventureComplaint () {}
}
