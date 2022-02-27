package com.isa.ISAproject.dto;

public class BoatRevisionDTO {
	private Long id;
	private BoatReservationDTO boatReservation;
	private RevisionDTO revision;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public BoatReservationDTO getBoatReservation() {
		return boatReservation;
	}
	public void setBoatReservation(BoatReservationDTO boatReservation) {
		this.boatReservation = boatReservation;
	}
	public RevisionDTO getRevision() {
		return revision;
	}
	public void setRevision(RevisionDTO revision) {
		this.revision = revision;
	}
	public BoatRevisionDTO(Long id, BoatReservationDTO boatReservation, RevisionDTO revision) {
		super();
		this.id = id;
		this.boatReservation = boatReservation;
		this.revision = revision;
	}
	public BoatRevisionDTO() {
		super();
	}
	
	
}
