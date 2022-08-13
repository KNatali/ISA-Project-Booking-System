package com.isa.ISAproject.dto;

public class CottageComplaintDTO {
	private Long id;
	private String description;
	private ClientProfileDTO client;
	private CottageReservationDTO cottage;
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
	public CottageReservationDTO getCottage() {
		return cottage;
	}
	public void setCottage(CottageReservationDTO cottage) {
		this.cottage = cottage;
	}
	public CottageComplaintDTO(Long id, String description, ClientProfileDTO client, CottageReservationDTO cottage) {
		super();
		this.id = id;
		this.description = description;
		this.client = client;
		this.cottage = cottage;
	}
	public CottageComplaintDTO() {
		super();
	}
	
	
}
