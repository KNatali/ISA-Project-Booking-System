package com.isa.ISAproject.dto;

public class AdventureComplaintDTO {
	private Long id;
	private String description;
	private ClientProfileDTO client;
	private AdventureDTO adventure;
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
	
	
	public AdventureDTO getAdventure() {
		return adventure;
	}
	public void setAdventure(AdventureDTO adventure) {
		this.adventure = adventure;
	}
	
	public AdventureComplaintDTO(Long id, String description, ClientProfileDTO client, AdventureDTO adventure) {
		super();
		this.id = id;
		this.description = description;
		this.client = client;
		this.adventure = adventure;
	}
	public AdventureComplaintDTO() {
		super();
	}
	
	

}
