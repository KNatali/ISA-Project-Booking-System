package com.isa.ISAproject.dto;

public class BoatOwnerReportDTO {
	private Long id;
	private String content;
	private boolean checkAdmin;
	private boolean penal;
	private boolean checked;
	private BoatReservationDTO boatReservation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	
	public BoatReservationDTO getBoatReservation() {
		return boatReservation;
	}
	public void setBoatReservation(BoatReservationDTO boatReservation) {
		this.boatReservation = boatReservation;
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
	public BoatOwnerReportDTO(Long id, String content, boolean checkAdmin, boolean penal,
			boolean checked,BoatReservationDTO boatReservation) {
		super();
		this.id = id;
		this.content = content;
		this.checkAdmin = checkAdmin;
		this.penal = penal;
		this.checked=checked;
		this.boatReservation = boatReservation;
	}
	public BoatOwnerReportDTO() {
		super();
	}
}
