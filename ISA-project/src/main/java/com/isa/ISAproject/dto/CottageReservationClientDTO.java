package com.isa.ISAproject.dto;

import java.util.Set;

public class CottageReservationClientDTO {
	  private Long id;
	  private String reservationStart;
	  private int numberOfDays;
	  private int numberOfPersons;
	  private int price;
	  private Set<AdditionalItemDTO> additionalItems;
	  private Long clientId;
	  private Long cottageId;
	  private int systemEarning;
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
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public int getNumberOfPersons() {
		return numberOfPersons;
	}
	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Set<AdditionalItemDTO> getAdditionalItems() {
		return additionalItems;
	}
	public void setAdditionalItems(Set<AdditionalItemDTO> additionalItems) {
		this.additionalItems = additionalItems;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getCottageId() {
		return cottageId;
	}
	public void setCottageId(Long cottageId) {
		this.cottageId = cottageId;
	}
	public int getSystemEarning() {
		return systemEarning;
	}
	public void setSystemEarning(int systemEarning) {
		this.systemEarning = systemEarning;
	}
	public CottageReservationClientDTO(Long id, String reservationStart, int numberOfDays, int numberOfPersons,
			int price, Set<AdditionalItemDTO> additionalItems, Long clientId, Long cottageId, int systemEarning) {
		super();
		this.id = id;
		this.reservationStart = reservationStart;
		this.numberOfDays = numberOfDays;
		this.numberOfPersons = numberOfPersons;
		this.price = price;
		this.additionalItems = additionalItems;
		this.clientId = clientId;
		this.cottageId = cottageId;
		this.systemEarning = systemEarning;
	}
	  
	public CottageReservationClientDTO() {}
}
