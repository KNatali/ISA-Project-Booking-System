package com.isa.ISAproject.dto;

public class AdventureCompletedReservationReportDTO {

	private Long id;
	private AdventureDTO adventure;
	private ClientProfileDTO client;
	private boolean adminCheck;
	private boolean getPenal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AdventureDTO getAdventure() {
		return adventure;
	}
	public void setAdventure(AdventureDTO adventure) {
		this.adventure = adventure;
	}
	public ClientProfileDTO getClient() {
		return client;
	}
	public void setClient(ClientProfileDTO client) {
		this.client = client;
	}
	public boolean isAdminCheck() {
		return adminCheck;
	}
	public void setAdminCheck(boolean adminCheck) {
		this.adminCheck = adminCheck;
	}
	public boolean isGetPenal() {
		return getPenal;
	}
	public void setGetPenal(boolean getPenal) {
		this.getPenal = getPenal;
	}
	public AdventureCompletedReservationReportDTO(Long id, AdventureDTO adventure, ClientProfileDTO client,
			boolean adminCheck, boolean getPenal) {
		super();
		this.id = id;
		this.adventure = adventure;
		this.client = client;
		this.adminCheck = adminCheck;
		this.getPenal = getPenal;
	}
	public AdventureCompletedReservationReportDTO() {
		super();
	}
	
	
}
