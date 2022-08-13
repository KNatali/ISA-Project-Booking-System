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
public class CottageComplaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String description;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private CottageReservation cottageReservation;
	
	@Enumerated(EnumType.STRING)
    private ComplaintType type;

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

	public CottageReservation getCottageReservation() {
		return cottageReservation;
	}

	public void setCottageReservation(CottageReservation cottageReservation) {
		this.cottageReservation = cottageReservation;
	}

	
	public ComplaintType getType() {
		return type;
	}

	public void setType(ComplaintType type) {
		this.type = type;
	}

	public CottageComplaint(Long id, String description, Client client, CottageReservation cottageReservation) {
		super();
		this.id = id;
		this.description = description;
		this.client = client;
		this.cottageReservation = cottageReservation;
	}
	public CottageComplaint(String description,CottageReservation cottageReservation) {
		this.description = description;
		this.cottageReservation = cottageReservation;
	}
	public CottageComplaint() {}
	
}
