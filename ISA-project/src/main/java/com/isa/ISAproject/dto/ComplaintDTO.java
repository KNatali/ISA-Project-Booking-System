package com.isa.ISAproject.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isa.ISAproject.model.AdventureComplaint;
import com.isa.ISAproject.model.AdventureReservation;
import com.isa.ISAproject.model.BoatComplaint;
import com.isa.ISAproject.model.BoatOwnerComplaint;
import com.isa.ISAproject.model.CottageComplaint;
import com.isa.ISAproject.model.CottageOwnerComplaint;
import com.isa.ISAproject.service.AdventureReservationService;

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
	public ComplaintDTO(CottageOwnerComplaint cottageOwnerComplaint) {
		this.id=cottageOwnerComplaint.getId();
		this.description=cottageOwnerComplaint.getDescription();
		this.idReservation=cottageOwnerComplaint.getCottageReservation().getId();
	}
	public ComplaintDTO(AdventureComplaint adventureComplaint) {
		this.id=adventureComplaint.getId();
		this.description=adventureComplaint.getDescription();
		//AdventureReservationService adventureReservationService = new AdventureReservationService();
		//trebam da pronadjem tu rezervaciju
		//AdventureReservation adv=adventureReservationService.findByClientAndAdventure(adventureComplaint.getClient(),adventureComplaint.getAdventure());
		//this.idReservation=adv.getId();
	}
}
