package com.isa.ISAproject.dto;

public class InstructorReportDTO {
	private Long id;
	private String content;
	private boolean checkAdmin;
	private boolean penal;
	private AdventureReservationDTO adventureReservation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	
	public AdventureReservationDTO getAdventureReservation() {
		return adventureReservation;
	}
	public void setAdventureReservation(AdventureReservationDTO adventureReservation) {
		this.adventureReservation = adventureReservation;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public boolean isCheckAdmin() {
		return checkAdmin;
	}
	public void setCheckAdmin(boolean checkAdmin) {
		this.checkAdmin = checkAdmin;
	}
	public boolean isPenal() {
		return penal;
	}
	public void setPenal(boolean penal) {
		this.penal = penal;
	}
	public InstructorReportDTO(Long id, String content, boolean checkAdmin, boolean penal,
			AdventureReservationDTO adventureReservation) {
		super();
		this.id = id;
		this.content = content;
		this.checkAdmin = checkAdmin;
		this.penal = penal;
		this.adventureReservation = adventureReservation;
	}
	public InstructorReportDTO() {
		super();
	}
	

}
