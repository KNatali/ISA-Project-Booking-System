package com.isa.ISAproject.dto;

public class BoatComplaintDTO {
	private Long id;
	private String description;
	private ClientProfileDTO client;
	private BoatReservationDTO boat;
	
	
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
	public ClientProfileDTO getClient() {
		return client;
	}
	public void setClient(ClientProfileDTO client) {
		this.client = client;
	}
	public BoatReservationDTO getBoat() {
		return boat;
	}
	public void setBoat(BoatReservationDTO boat) {
		this.boat = boat;
	}
	public BoatComplaintDTO(Long id, String description, ClientProfileDTO client, BoatReservationDTO boat) {
		super();
		this.id = id;
		this.description = description;
		this.client = client;
		this.boat = boat;
	}
	public BoatComplaintDTO() {
		super();
	}
	
	
}
