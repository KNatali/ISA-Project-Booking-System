package com.isa.ISAproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class InstructorReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String content;
	@Column 
	private boolean checkAdmin;
	@Column
	private boolean penal;
	
	@OneToOne
	private AdventureReservation adventureReservation;
	
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
	
	
	public AdventureReservation getAdventureReservation() {
		return adventureReservation;
	}
	public void setAdventureReservation(AdventureReservation adventureReservation) {
		this.adventureReservation = adventureReservation;
	}
	
	public InstructorReport(Long id, String content, boolean checkAdmin, boolean penal,
			AdventureReservation adventureReservation) {
		super();
		this.id = id;
		this.content = content;
		this.checkAdmin = checkAdmin;
		this.penal = penal;
		this.adventureReservation = adventureReservation;
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
	public InstructorReport() {
		super();
	}
	
	
	
}
