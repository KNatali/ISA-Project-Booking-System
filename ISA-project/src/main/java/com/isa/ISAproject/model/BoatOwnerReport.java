package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BoatOwnerReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String content;
	@Column 
	private boolean checkAdmin;
	@Column
	private boolean penal;
	@Column
	private boolean checked;
	@OneToOne
	private BoatReservation boatReservation;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
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
	public BoatReservation getBoatReservation() {
		return boatReservation;
	}
	public void setBoatReservation(BoatReservation boatReservation) {
		this.boatReservation = boatReservation;
	}
	
	public BoatOwnerReport(Long id, String content, boolean checkAdmin, boolean penal,
			boolean checked,BoatReservation boatReservation) {
		super();
		this.id = id;
		this.content = content;
		this.checkAdmin = checkAdmin;
		this.penal = penal;
		this.checked=checked;
		this.boatReservation = boatReservation;
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
	public BoatOwnerReport() {
		super();
	}
}
