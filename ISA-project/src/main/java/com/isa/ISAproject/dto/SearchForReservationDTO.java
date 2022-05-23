package com.isa.ISAproject.dto;

import java.time.LocalDateTime;

public class SearchForReservationDTO {
	private Long id;
	private String dateAndTime;
	private int numOfDay;
	private int numOfPerson;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public int getNumOfPerson() {
		return numOfPerson;
	}
	public void setNumOfPerson(int numOfPerson) {
		this.numOfPerson = numOfPerson;
	}
	public int getNumOfDay() {
		return numOfDay;
	}
	public void setNumOfDay(int numOfDay) {
		this.numOfDay = numOfDay;
	}
	
	public SearchForReservationDTO(Long id, String dateAndTime, int numOfDay, int numOfPerson) {
		super();
		this.id = id;
		this.dateAndTime = dateAndTime;
		this.numOfDay = numOfDay;
		this.numOfPerson = numOfPerson;
	}
	public SearchForReservationDTO() {}
}