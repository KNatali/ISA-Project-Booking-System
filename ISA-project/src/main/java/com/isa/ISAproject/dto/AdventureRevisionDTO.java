package com.isa.ISAproject.dto;

import com.isa.ISAproject.model.AdventureRevision;

public class AdventureRevisionDTO {
	
	private Long id;
	private AdventureReservationDTO adventureReservation;
	private RevisionDTO revision;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AdventureReservationDTO getAdventureReservation() {
		return adventureReservation;
	}
	public void setAdventureReservation(AdventureReservationDTO adventureReservation) {
		this.adventureReservation = adventureReservation;
	}
	public RevisionDTO getRevision() {
		return revision;
	}
	public void setRevision(RevisionDTO revision) {
		this.revision = revision;
	}
	public AdventureRevisionDTO(Long id, AdventureReservationDTO adventureReservation, RevisionDTO revision) {
		super();
		this.id = id;
		this.adventureReservation = adventureReservation;
		this.revision = revision;
	}
	public AdventureRevisionDTO(AdventureRevision a) {
		super();
		this.id = a.getId();
		this.adventureReservation = new AdventureReservationDTO(a.getAdventureReservation());
		this.revision = new RevisionDTO(a.getRevision());
	}
	public AdventureRevisionDTO() {
		super();
	}
	
	

}
