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
	private BoatOwner boatOwner;

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

	public BoatOwner getBoatOwner() {
		return boatOwner;
	}

	public void setBoatOwner(BoatOwner boatOwner) {
		this.boatOwner = boatOwner;
	}

	public BoatOwnerComplaint(Long id, String description, BoatOwner boatOwner) {
		super();
		this.id = id;
		this.description = description;
		this.boatOwner = boatOwner;
	}
	public BoatOwnerComplaint( String description, BoatOwner boatOwner) {
		this.description = description;
		this.boatOwner = boatOwner;
	}
	
	public BoatOwnerComplaint() {}
	
	

}
