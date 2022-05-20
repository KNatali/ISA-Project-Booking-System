package com.isa.ISAproject.dto;

import com.isa.ISAproject.model.BoatOwnerComplaint;

public class BoatOwnerComplaintDTO {
	private Long id;
	private String description;
	private Long idOwner;
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
	public Long getIdOwner() {
		return idOwner;
	}
	public void setIdOwner(Long idOwner) {
		this.idOwner = idOwner;
	}
	
	public BoatOwnerComplaintDTO() {}
	public BoatOwnerComplaintDTO(Long id, String description, Long idOwner) {
		super();
		this.id = id;
		this.description = description;
		this.idOwner = idOwner;
	}
	public BoatOwnerComplaintDTO(BoatOwnerComplaint com) {
		this.id = com.getId();
		this.description = com.getDescription();
		this.idOwner = com.getBoatOwner().getId();
	}
	
}
