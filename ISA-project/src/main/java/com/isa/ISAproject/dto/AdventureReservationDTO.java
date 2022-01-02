package com.isa.ISAproject.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.isa.ISAproject.model.AdventureReservation;

public class AdventureReservationDTO {
	private Long id;
	private LocalDateTime reservationStart;
	private LocalDateTime reservationEnd;
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
	public LocalDateTime getReservationStart() {
		return reservationStart;
	}
	public void setReservationStart(LocalDateTime reservationStart) {
		this.reservationStart = reservationStart;
	}
	
	public int getNumberOfPersons() {
		return numberOfPersons;
	}
	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}
	public LocalDateTime getResevationEnd() {
		return reservationEnd;
	}
	public void setResevationEnd(LocalDateTime resevationEnd) {
		this.reservationEnd = resevationEnd;
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
	public AdventureReservationDTO(Long id, LocalDateTime reservationStart, LocalDateTime resevationEnd, AdventureDTO adventure,
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
		this.id = boatReservation.getId();
		this.reservationStart = boatReservation.getReservationStart();
		this.reservationEnd = boatReservation.getReservationEnd();
		this.adventure = new AdventureDTO(boatReservation.getAdventure());
		this.price = boatReservation.getPrice();
		this.numberOfPersons=boatReservation.getNumberOfPersons();
		this.client = new ClientProfileDTO(boatReservation.getClient());
	}
	public AdventureReservationDTO() {
		super();
	}
	
	
	

}
