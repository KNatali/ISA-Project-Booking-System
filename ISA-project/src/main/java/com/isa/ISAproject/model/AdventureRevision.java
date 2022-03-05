package com.isa.ISAproject.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class AdventureRevision {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private AdventureReservation adventureReservation;
	
	@OneToOne
	private Revision revision;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AdventureReservation getAdventureReservation() {
		return adventureReservation;
	}

	public void setAdventureReservation(AdventureReservation adventureReservation) {
		this.adventureReservation = adventureReservation;
	}

	public Revision getRevision() {
		return revision;
	}

	public void setRevision(Revision revision) {
		this.revision = revision;
	}

	public AdventureRevision(Long id, AdventureReservation adventureReservation, Revision revision) {
		super();
		this.id = id;
		this.adventureReservation = adventureReservation;
		this.revision = revision;
	}
	public AdventureRevision(AdventureReservation adventureReservation, Revision revision) {
		this.adventureReservation = adventureReservation;
		this.revision = revision;
	}

	public AdventureRevision() {
		super();
	}
	
	

}
