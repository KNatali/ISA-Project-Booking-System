package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BoatOwnerComplaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String description;
	
	@ManyToOne
	private BoatReservation boatReservation;
	//treba rezervacija**

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

	public BoatReservation getBoatReservation() {
		return boatReservation;
	}

	public void setBoatReservation(BoatReservation boatReservation) {
		this.boatReservation = boatReservation;
	}

	public BoatOwnerComplaint(Long id, String description, BoatReservation boatReservation) {
		super();
		this.id = id;
		this.description = description;
		this.boatReservation = boatReservation;
	}
	public BoatOwnerComplaint(String description, BoatReservation boatReservation) {
		this.description = description;
		this.boatReservation = boatReservation;
	}

	
	public BoatOwnerComplaint() {}
	
	

}
