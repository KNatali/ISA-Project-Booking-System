package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CottageOwnerComplaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String description;
	
	@ManyToOne
	private CottageReservation cottageReservation;

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

	public CottageReservation getCottageReservation() {
		return cottageReservation;
	}

	public void setCottageReservation(CottageReservation cottageReservation) {
		this.cottageReservation = cottageReservation;
	}

	public CottageOwnerComplaint(Long id, String description, CottageReservation cottageReservation) {
		super();
		this.id = id;
		this.description = description;
		this.cottageReservation = cottageReservation;
	}
	public CottageOwnerComplaint(String description, CottageReservation cottageReservation) {
		this.description = description;
		this.cottageReservation = cottageReservation;
	}
	public CottageOwnerComplaint() {}
	
}
