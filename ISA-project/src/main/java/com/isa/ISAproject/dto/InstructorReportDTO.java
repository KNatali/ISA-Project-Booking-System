package com.isa.ISAproject.dto;

public class InstructorReportDTO {
	private Long id;
	private String content;
	private boolean checkAdmin;
	private boolean penal;
	private boolean checked;
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
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
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
			boolean checked,AdventureReservationDTO adventureReservation) {
		super();
		this.id = id;
		this.content = content;
		this.checkAdmin = checkAdmin;
		this.penal = penal;
		this.checked=checked;
		this.adventureReservation = adventureReservation;
	}
	public InstructorReportDTO() {
		super();
	}
	

}
