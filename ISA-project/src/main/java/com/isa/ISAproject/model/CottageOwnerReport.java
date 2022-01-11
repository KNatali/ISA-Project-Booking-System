package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CottageOwnerReport {
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
	private CottageReservation cottageReservation;
	
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
	public CottageReservation getCottageReservation() {
		return cottageReservation;
	}
	public void setCottageReservation(CottageReservation cottageReservation) {
		this.cottageReservation = cottageReservation;
	}
	
	public CottageOwnerReport(Long id, String content, boolean checkAdmin, boolean penal,
			boolean checked,CottageReservation cottageReservation) {
		super();
		this.id = id;
		this.content = content;
		this.checkAdmin = checkAdmin;
		this.penal = penal;
		this.checked=checked;
		this.cottageReservation = cottageReservation;
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
	public CottageOwnerReport() {
		super();
	}
}
