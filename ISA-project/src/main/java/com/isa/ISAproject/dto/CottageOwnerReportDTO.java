package com.isa.ISAproject.dto;

public class CottageOwnerReportDTO {
	private Long id;
	private String content;
	private boolean checkAdmin;
	private boolean penal;
	private boolean checked;
	private CottageReservationDTO cottageReservation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	
	public CottageReservationDTO getCottageReservation() {
		return cottageReservation;
	}
	public void setCottageReservation(CottageReservationDTO cottageReservation) {
		this.cottageReservation = cottageReservation;
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
	public CottageOwnerReportDTO(Long id, String content, boolean checkAdmin, boolean penal,
			boolean checked,CottageReservationDTO cottageReservation) {
		super();
		this.id = id;
		this.content = content;
		this.checkAdmin = checkAdmin;
		this.penal = penal;
		this.checked=checked;
		this.cottageReservation = cottageReservation;
	}
	public CottageOwnerReportDTO() {
		super();
	}
}
