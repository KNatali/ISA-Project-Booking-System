package com.isa.ISAproject.dto;

import com.isa.ISAproject.model.BoatComplaint;
import com.isa.ISAproject.model.BoatOwnerComplaint;
import com.isa.ISAproject.model.CottageComplaint;

public class ComplaintDTO {
	private Long id;
	private String description;
	private Long idReservation;
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
	
	
	public Long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}
	public ComplaintDTO() {}
	public ComplaintDTO(Long id, String description, Long idReservation) {
		super();
		this.id = id;
		this.description = description;
		this.idReservation = idReservation;
	}
	public ComplaintDTO(BoatComplaint boatComplaint) {
		this.id=boatComplaint.getId();
		this.description=boatComplaint.getDescription();
		this.idReservation=boatComplaint.getBoatReservation().getId();
	}
	public ComplaintDTO(BoatOwnerComplaint boatOwnerComplaint) {
		this.id=boatOwnerComplaint.getId();
		this.description=boatOwnerComplaint.getDescription();
		this.idReservation=boatOwnerComplaint.getBoatReservation().getId();
	}
	public ComplaintDTO(CottageComplaint cottageComplaint) {
		this.id=cottageComplaint.getId();
		this.description=cottageComplaint.getDescription();
		this.idReservation=cottageComplaint.getCottageReservation().getId();
	}
	
}
