package com.isa.ISAproject.dto;

import com.isa.ISAproject.model.AdventureRevision;
import com.isa.ISAproject.model.CottageRevision;

public class CottageRevisionDTO {

	private Long id;
	private CottageReservationDTO cottageReservation;
	private RevisionDTO revision;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public CottageReservationDTO getCottageReservation() {
		return cottageReservation;
	}
	public void setCottageReservation(CottageReservationDTO cottageReservation) {
		this.cottageReservation = cottageReservation;
	}
	public RevisionDTO getRevision() {
		return revision;
	}
	public void setRevision(RevisionDTO revision) {
		this.revision = revision;
	}
	public CottageRevisionDTO(Long id, CottageReservationDTO cottageReservation, RevisionDTO revision) {
		super();
		this.id = id;
		this.cottageReservation = cottageReservation;
		this.revision = revision;
	}
	public CottageRevisionDTO(CottageRevision a) {
		super();
		this.id = a.getId();
		this.cottageReservation = new CottageReservationDTO(a.getCottageReservation());
		this.revision = new RevisionDTO(a.getRevision());
	}
	public CottageRevisionDTO() {
		super();
	}
	
	
}
