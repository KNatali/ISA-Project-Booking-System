package com.isa.ISAproject.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import com.isa.ISAproject.model.AdventureReservation;

public class AdventureReservationDTO {
	private Long id;
	private String reservationStart;
	private String reservationEnd;
	private AdventureDTO adventure;
	private double price;
	private int numberOfPersons;
	private ClientProfileDTO client;
	private Set<AdditionalItemDTO> additionalItems=new HashSet<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public int getNumberOfPersons() {
		return numberOfPersons;
	}
	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}
	
	public String getReservationStart() {
		return reservationStart;
	}
	public void setReservationStart(String reservationStart) {
		this.reservationStart = reservationStart;
	}
	public String getReservationEnd() {
		return reservationEnd;
	}
	public void setReservationEnd(String reservationEnd) {
		this.reservationEnd = reservationEnd;
	}
	public AdventureDTO getAdventure() {
		return adventure;
	}
	public void setAdventure(AdventureDTO adventure) {
		this.adventure = adventure;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ClientProfileDTO getClient() {
		return client;
	}
	public void setClient(ClientProfileDTO client) {
		this.client = client;
	}
	
	public Set<AdditionalItemDTO> getAdditionalItems() {
		return additionalItems;
	}
	public void setAdditionalItems(Set<AdditionalItemDTO> additionalItems) {
		this.additionalItems = additionalItems;
	}
	public AdventureReservationDTO(Long id, String reservationStart, String resevationEnd, AdventureDTO adventure,
			double price,int persons, ClientProfileDTO client,  Set<AdditionalItemDTO> additionalItems) {
		super();
		this.id = id;
		this.reservationStart = reservationStart;
		this.reservationEnd = resevationEnd;
		this.adventure = adventure;
		this.price = price;
		this.numberOfPersons=persons;
		this.client = client;
		this.additionalItems = additionalItems;
	}
	public AdventureReservationDTO(AdventureReservation boatReservation) {
		super();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		this.id = boatReservation.getId();
		this.reservationStart = boatReservation.getReservationStart().format(formatter);
		this.reservationEnd = boatReservation.getReservationEnd().format(formatter);
		this.adventure = new AdventureDTO(boatReservation.getAdventure());
		this.price = boatReservation.getPrice();
		this.numberOfPersons=boatReservation.getNumberOfPersons();
		this.client = new ClientProfileDTO(boatReservation.getClient());
	}
	public AdventureReservationDTO() {
		super();
	}
	
	
	

}
