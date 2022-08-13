package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class BoatComplaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String description;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private BoatReservation boatReservation;

	@Enumerated(EnumType.STRING)
    private ComplaintType type;
	
	public Long getId() {
		return id;
	}

	public ComplaintType getType() {
		return type;
	}

	public void setType(ComplaintType type) {
		this.type = type;
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

	public BoatReservation getBoatReservation() {
		return boatReservation;
	}

	public void setBoatReservation(BoatReservation boatReservation) {
		this.boatReservation = boatReservation;
	}

	public BoatComplaint(Long id, String description, Client client, BoatReservation boatReservation) {
		super();
		this.id = id;
		this.description = description;
		this.client = client;
		this.boatReservation = boatReservation;
	}
	public BoatComplaint( String description, BoatReservation boatReservation) {
		super();
		this.description = description;
		this.boatReservation = boatReservation;
	}
	
	public BoatComplaint () {}
}
