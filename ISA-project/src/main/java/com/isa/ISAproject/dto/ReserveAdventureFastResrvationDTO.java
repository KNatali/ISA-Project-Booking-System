package com.isa.ISAproject.dto;

import java.util.HashSet;
import java.util.Set;

public class ReserveAdventureFastResrvationDTO {
	private Long id;
	private String reservationStart;
	private String reservationEnd;
	private double durationHours;
	private int maxPersons;
	private double price;
	private String validityStart;
	private String validityEnd;
	private AdventureDTO adventure;
	private ClientProfileDTO client;
	private Set<AdditionalItemDTO> additionalItems=new HashSet<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public double getDurationHours() {
		return durationHours;
	}
	public void setDurationHours(double durationHours) {
		this.durationHours = durationHours;
	}
	public int getMaxPersons() {
		return maxPersons;
	}
	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getValidityStart() {
		return validityStart;
	}
	public void setValidityStart(String validityStart) {
		this.validityStart = validityStart;
	}
	public String getValidityEnd() {
		return validityEnd;
	}
	public void setValidityEnd(String validityEnd) {
		this.validityEnd = validityEnd;
	}
	public AdventureDTO getAdventure() {
		return adventure;
	}
	public void setAdventure(AdventureDTO adventure) {
		this.adventure = adventure;
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
	public ReserveAdventureFastResrvationDTO(Long id, String reservationStart, String reservationEnd,
			double durationHours, int maxPersons, double price, String validityStart, String validityEnd,
			AdventureDTO adventure, ClientProfileDTO client, Set<AdditionalItemDTO> additionalItems) {
		super();
		this.id = id;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.durationHours = durationHours;
		this.maxPersons = maxPersons;
		this.price = price;
		this.validityStart = validityStart;
		this.validityEnd = validityEnd;
		this.adventure = adventure;
		this.client = client;
		this.additionalItems = additionalItems;
	}
	public ReserveAdventureFastResrvationDTO() {}
	
}
