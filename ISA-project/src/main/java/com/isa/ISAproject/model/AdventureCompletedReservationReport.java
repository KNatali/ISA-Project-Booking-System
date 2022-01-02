package com.isa.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AdventureCompletedReservationReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "adventure_id")
    private Adventure adventure;
	
	@ManyToOne
	private Client client;
	
	@Column
	private String message;
	
	@Column
	private boolean adminCheck;
	@Column
	private boolean getPenal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Adventure getAdventure() {
		return adventure;
	}
	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	public AdventureCompletedReservationReport(Long id, Adventure adventure, Client client, String message,
			boolean adminCheck, boolean getPenal) {
		super();
		this.id = id;
		this.adventure = adventure;
		this.client = client;
		this.message = message;
		this.adminCheck = adminCheck;
		this.getPenal = getPenal;
	}
	public AdventureCompletedReservationReport() {
		super();
	}
	
	
	
}
